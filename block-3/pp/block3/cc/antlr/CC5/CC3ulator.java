package pp.block3.cc.antlr.CC5;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import pp.block3.cc.antlr.CC5.CC3Parser.*;


public class CC3ulator extends CC3BaseListener {
    /** Map storing the val attribute for all parse tree nodes. */
    private ParseTreeProperty<Type> types;

    /** Initialises the calculator before using it to walk a tree. */
    public void init() {
        types = new ParseTreeProperty<>();
    }

    @Override
    public void exitPar(ParContext ctx) {
        set(ctx, val(ctx.term()));
    }

    @Override
    public void exitHat(HatContext ctx) {
        if(val(ctx.term(1)) != Type.NUM){
            set(ctx, Type.ERR);
        } else if (val(ctx.term(0)) == Type.NUM || val(ctx.term(0)) == Type.STR) {
            set(ctx, val(ctx.term(0)));
        } else {
            set(ctx, Type.ERR);
        }
    }

    @Override
    public void exitPlus(PlusContext ctx) {
        if(val(ctx.term(0)) == val(ctx.term(1))){
            set(ctx, val(ctx.term(0)));
        } else{
            set(ctx, Type.ERR);
        }
    }

    @Override
    public void exitEqual(EqualContext ctx) {
        if(val(ctx.term(0)) == val(ctx.term(1))){
            set(ctx, Type.BOOL);
        } else{
            set(ctx, Type.ERR);
        }
    }

    @Override
    public void exitNumber(NumberContext ctx) {
        set(ctx, Type.NUM);
    }

    @Override
    public void exitBoolean(BooleanContext ctx) {
        set(ctx, Type.BOOL);
    }
    @Override
    public void exitString(StringContext ctx) {
        set(ctx, Type.STR);
    }

    /** Sets the type attribute of a given node. */
    private void set(ParseTree node, Type type) {
        types.put(node, type);
    }

    /** Retrieves the type attribute of a given node. */
    public Type val(ParseTree node) {
        return types.get(node);
    }
}
