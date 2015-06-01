package pp.block5.cc.simple;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import pp.block5.cc.pascal.SimplePascalBaseVisitor;
import pp.block5.cc.pascal.SimplePascalParser;
import pp.block5.cc.pascal.SimplePascalParser.*;
import pp.iloc.Simulator;
import pp.iloc.model.*;
/** Class to generate ILOC code for Simple Pascal. */
public class Generator extends SimplePascalBaseVisitor<Op> {
    /**
     * The representation of the boolean value <code>false</code>.
     */
    public final static Num FALSE_VALUE = new Num(Simulator.FALSE);
    /**
     * The representation of the boolean value <code>true</code>.
     */
    public final static Num TRUE_VALUE = new Num(Simulator.TRUE);

    /**
     * The base register.
     */
    private Reg arp = new Reg("r_arp");
    /**
     * The outcome of the checker phase.
     */
    private Result checkResult;
    /**
     * Association of statement nodes to labels.
     */
    private ParseTreeProperty<Label> labels;
    /**
     * The program being built.
     */
    private Program program;
    /**
     * Register count, used to generate fresh registers.
     */
    private int regCount;
    /**
     * Association of expression and target nodes to registers.
     */
    private ParseTreeProperty<Reg> regs;

    public Program generate(ParseTree tree, Result checkResult) {
        this.program = new Program();
        this.checkResult = checkResult;
        this.regs = new ParseTreeProperty<>();
        this.labels = new ParseTreeProperty<>();
        this.regCount = 0;
        tree.accept(this);
        return this.program;
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(Label label, OpCode opCode, Operand... args) {
        Op result = new Op(label, opCode, args);
        this.program.addInstr(result);
        return result;
    }

    /**
     * Constructs an operation from the parameters
     * and adds it to the program under construction.
     */
    private Op emit(OpCode opCode, Operand... args) {
        return emit((Label) null, opCode, args);
    }

    /**
     * Looks up the label for a given parse tree node,
     * creating it if none has been created before.
     * The label is actually constructed from the entry node
     * in the flow graph, as stored in the checker result.
     */
    private Label getOrCreateLabel(ParserRuleContext node) {
        Label result = this.labels.get(node);
        if (result == null) {
            ParserRuleContext entry = this.checkResult.getEntry(node);
            result = createLabel(entry, "n");
            this.labels.put(node, result);
        }
        return result;
    }

    /**
     * Creates a label for a given parse tree node and prefix.
     */
    private Label createLabel(ParserRuleContext node, String prefix) {
        Token token = node.getStart();
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        String result = prefix + "_" + line + "_" + column;
        return new Label(result);
    }

    /**
     * Retrieves the offset of a variable node from the checker result,
     * wrapped in a {@link Num} operand.
     */
    private Num getOffset(ParseTree node) {
        return new Num(this.checkResult.getOffset(node));
    }

    /**
     * Returns a register for a given parse tree node,
     * creating a fresh register if there is none for that node.
     */
    private Reg getOrCreateReg(ParseTree node) {
        Reg result = this.regs.get(node);
        if (result == null) {
            result = new Reg("r_" + this.regCount);
            this.regs.put(node, result);
            this.regCount++;
        }
        return result;
    }

    /**
     * Assigns a register to a given parse tree node.
     */
    private void setReg(ParseTree node, Reg reg) {
        this.regs.put(node, reg);
    }

    @Override
    public Op visitProgram(@NotNull SimplePascalParser.ProgramContext ctx) {
        return visit(ctx.body());
    }

    @Override
    public Op visitBody(@NotNull SimplePascalParser.BodyContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Op visitBlock(@NotNull SimplePascalParser.BlockContext ctx) {
        Op result = visit(ctx.stat(0));

        for (StatContext stat : ctx.stat()) {
            if (stat == ctx.stat(0)) { continue; }
            visit(stat);
        }

        return result;
    }

    @Override
    public Op visitAssStat(@NotNull SimplePascalParser.AssStatContext ctx) {
        Op result = visit(ctx.expr());

        Reg register = getOrCreateReg(ctx.expr());
        Num targetOffset = getOffset(ctx.target());

        emit(OpCode.storeAI, register, arp, targetOffset);

        return result;
    }

    @Override
    public Op visitIfStat(@NotNull SimplePascalParser.IfStatContext ctx) {
        Label thenLabel = createLabel(ctx, "then");
        Label endLabel = createLabel(ctx, "if_end");

        Reg register = getOrCreateReg(ctx.expr());
        setReg(ctx, register);

        Op result = visit(ctx.expr());

        if (ctx.getChildCount() == 1) {
            emit(OpCode.cbr, register, thenLabel, endLabel);
            visit(ctx.stat(0)).setLabel(thenLabel);
        } else {
            Label elseLabel = createLabel(ctx, "else");
            emit(OpCode.cbr, register, thenLabel, elseLabel);
            visit(ctx.stat(0)).setLabel(thenLabel);
            emit(OpCode.jumpI, endLabel);
            visit(ctx.stat(1)).setLabel(elseLabel);
        }

        emit(endLabel, OpCode.nop);

        return result;
    }

    @Override
    public Op visitWhileStat(@NotNull SimplePascalParser.WhileStatContext ctx) {
        Label beginWhileLabel = createLabel(ctx, "while");
        Label bodyLabel = createLabel(ctx, "while_body");
        Label endLabel = createLabel(ctx, "while_end");

        Op result = visit(ctx.expr());
        result.setLabel(beginWhileLabel);

        Reg register = getOrCreateReg(ctx.expr());
        setReg(ctx, register);

        emit(OpCode.cbr, register, bodyLabel, endLabel);

        visit(ctx.stat()).setLabel(bodyLabel);

        emit(OpCode.jumpI, beginWhileLabel);
        emit(endLabel, OpCode.nop);

        return result;
    }

    @Override
    public Op visitBlockStat(@NotNull SimplePascalParser.BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public Op visitInStat(@NotNull SimplePascalParser.InStatContext ctx) {
        Reg target = getOrCreateReg(ctx.target());
        String text = ctx.STR().getText().replaceAll("\"", "");
        Op result = emit(OpCode.in, new Str(text), target);

        Num ctxOffset = getOffset(ctx);
        emit(OpCode.storeAI, target, arp, ctxOffset);

        return result;
    }

    @Override
    public Op visitOutStat(@NotNull SimplePascalParser.OutStatContext ctx) {
        Op result = visit(ctx.expr());
        String text = ctx.STR().getText().replaceAll("\"", "");

        Reg exprRegister = getOrCreateReg(ctx.expr());

        emit(OpCode.out, new Str(text), exprRegister);

        return result;
    }

    @Override
    public Op visitParExpr(@NotNull ParExprContext ctx) {
        setReg(ctx, getOrCreateReg(ctx.expr()));

        return visit(ctx.expr());
    }

    @Override
    public Op visitTrueExpr(@NotNull TrueExprContext ctx) {
        return emit(OpCode.loadI, TRUE_VALUE, getOrCreateReg(ctx));
    }

    @Override
    public Op visitCompExpr(@NotNull CompExprContext ctx) {
        Op result = visit(ctx.expr(0));
        visit(ctx.expr(1));

        Reg expr0 = getOrCreateReg(ctx.expr(0));
        Reg expr1 = getOrCreateReg(ctx.expr(1));
        Reg ctxRegister = getOrCreateReg(ctx);

        if (ctx.compOp().EQ() != null) {
            emit(OpCode.cmp_EQ, expr0, expr1, ctxRegister);
        } else if(ctx.compOp().GE() != null) {
            emit(OpCode.cmp_GE, expr0, expr1, ctxRegister);
        } else if(ctx.compOp().GT() != null) {
            emit(OpCode.cmp_GT, expr0, expr1, ctxRegister);
        } else if(ctx.compOp().LE() != null) {
            emit(OpCode.cmp_LE, expr0, expr1, ctxRegister);
        } else if(ctx.compOp().LT() != null) {
            emit(OpCode.cmp_LT, expr0, expr1, ctxRegister);
        } else {
            emit(OpCode.cmp_NE, expr0, expr1, ctxRegister);
        }

        return result;
    }

    @Override
    public Op visitPrfExpr(@NotNull PrfExprContext ctx) {
        Op result = visit(ctx.expr());

        Reg exprRegister = getOrCreateReg(ctx.expr());
        Reg ctxRegister = getOrCreateReg(ctx);

        if (ctx.prfOp().MINUS() != null) {
            emit(OpCode.rsubI, exprRegister, new Num(0), ctxRegister);
        } else {
            emit(OpCode.xorI, exprRegister, TRUE_VALUE, ctxRegister);
        }

        return result;
    }

    @Override
    public Op visitFalseExpr(@NotNull FalseExprContext ctx) {
        return emit(OpCode.loadI, FALSE_VALUE, getOrCreateReg(ctx));
    }

    @Override
    public Op visitBoolExpr(@NotNull BoolExprContext ctx) {
        Op result = visit(ctx.expr(0));
        visit(ctx.expr(1));

        Reg expr0Register = getOrCreateReg(ctx.expr(0));
        Reg expr1Register = getOrCreateReg(ctx.expr(1));
        Reg ctxRegister = getOrCreateReg(ctx);

        if (ctx.boolOp().AND() != null) {
            emit(OpCode.and, expr0Register, expr1Register, ctxRegister);
        } else {
            emit(OpCode.or, expr0Register, expr1Register, ctxRegister);
        }

        return result;
    }

    @Override
    public Op visitMultExpr(@NotNull MultExprContext ctx) {
        Op result = visit(ctx.expr(0));
        visit(ctx.expr(1));

        Reg expr0Register = getOrCreateReg(ctx.expr(0));
        Reg expr1Register = getOrCreateReg(ctx.expr(1));
        Reg ctxRegister = getOrCreateReg(ctx);

        if (ctx.multOp().STAR() != null) {
            emit(OpCode.mult, expr0Register, expr1Register, ctxRegister);
        } else {
            emit(OpCode.div, expr0Register, expr1Register, ctxRegister);
        }

        return result;
    }

    @Override
    public Op visitNumExpr(@NotNull NumExprContext ctx) {
        Num number = new Num(Integer.parseInt(ctx.getText()));

        return emit(OpCode.loadI, number, getOrCreateReg(ctx));
    }

    @Override
    public Op visitPlusExpr(@NotNull PlusExprContext ctx) {
        Op result = visit(ctx.expr(0));
        visit(ctx.expr(1));

        Reg expr0Register = getOrCreateReg(ctx.expr(0));
        Reg expr1Register = getOrCreateReg(ctx.expr(1));
        Reg ctxRegister = getOrCreateReg(ctx);

        if (ctx.plusOp().PLUS() != null) {
            emit(OpCode.add, expr0Register, expr1Register, ctxRegister);
        } else {
            emit(OpCode.sub, expr0Register, expr1Register, ctxRegister);
        }

        return result;
    }

    @Override
    public Op visitIdExpr(@NotNull IdExprContext ctx) {
        return emit(OpCode.loadAI, arp, getOffset(ctx), getOrCreateReg(ctx));
    }
}
