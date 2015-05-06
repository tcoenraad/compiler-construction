package pp.block2.cc.ll;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.List;

import static pp.block2.cc.ll.CC4.*;


public class CC4Parser implements Parser {
    private static final NonTerm L = new NonTerm("L");
    private static final NonTerm R = new NonTerm("R");
    private static final NonTerm Q = new NonTerm("Q");
    private static final NonTerm R2 = new NonTerm("R2");
    private static final NonTerm Q2 = new NonTerm("Q2");

    private final SymbolFactory fact;
    private List<? extends Token> tokens;
    private int index;

    public CC4Parser() {
        this.fact = new SymbolFactory(CC4.class);
    }

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        this.tokens = lexer.getAllTokens();
        this.index = 0;
        return parseL(); // L == start symbol
    }

    private AST parseL() throws ParseException {
        AST tree = new AST(L);
        Token next = peek();
        switch(next.getType()){
            case A:
                tree.addChild(parseR());
                tree.addChild(parseToken(A));
                break;
            case B:
                tree.addChild(parseQ());
                tree.addChild(parseToken(B));
                tree.addChild(parseToken(A));
                break;
            case C:
                tree.addChild(parseR());
                tree.addChild(parseToken(A));
                break;
            default:
                throw unparsable(L);
        }
        return tree;
    }

    private AST parseR() throws ParseException {
        AST tree = new AST(R);
        Token next = peek();
        switch (next.getType()) {
            case A:
                tree.addChild(parseToken(A));
                tree.addChild(parseToken(B));
                tree.addChild(parseToken(A));
                tree.addChild(parseR2());
                break;
            case C:
                tree.addChild(parseToken(C));
                tree.addChild(parseToken(A));
                tree.addChild(parseToken(B));
                tree.addChild(parseToken(A));
                tree.addChild(parseR2());
                break;
            default:
                throw unparsable(R);
        }
        return tree;
    }

    private AST parseQ() throws ParseException {
        AST tree = new AST(Q);
        Token next = peek();
        switch (next.getType()) {
            case B:
                tree.addChild(parseToken(B));
                tree.addChild(parseQ2());
                break;
            default:
                throw unparsable(Q);
        }
        return tree;
    }


    private AST parseR2() throws ParseException {
        AST tree = new AST(R2);
        Token next = peek();
        switch (next.getType()) {
            case B:
                tree.addChild(parseToken(B));
                tree.addChild(parseToken(C));
                tree.addChild(parseR2());
                break;
            case A:
                break;
            default:
                throw unparsable(R2);
        }
        return tree;
    }

    private AST parseQ2() throws ParseException {
        AST tree = new AST(Q2);
        Token next = peek();
        switch(next.getType()){
            case B:
                tree.addChild(parseToken(B));
                tree.addChild(parseToken(C));
                break;
            case C:
                tree.addChild(parseToken(C));
                break;
            default:
                throw unparsable(Q2);
        }
        return tree;
    }

    private ParseException unparsable(NonTerm nt) {
        try {
            Token next = peek();
            return new ParseException(String.format(
                    "Line %d:%d - could not parse '%s' at token '%s'",
                    next.getLine(), next.getCharPositionInLine(), nt.getName(),
                    fact.get(next.getType())));
        } catch (ParseException e) {
            return e;
        }
    }


    /** Creates an AST based on the expected token type. */
    private AST parseToken(int tokenType) throws ParseException {
        Token next = next();
        if (next.getType() != tokenType) {
            throw new ParseException(String.format(
                    "Line %d:%d - expected token '%s' but found '%s'",
                    next.getLine(), next.getCharPositionInLine(),
                    fact.get(tokenType), fact.get(next.getType())));
        }
        return new AST(fact.getTerminal(tokenType), next);
    }

    /** Returns the next token, without moving the token index. */
    private Token peek() throws ParseException {
        if (index >= tokens.size()) {
            throw new ParseException("Reading beyond end of input");
        }
        return tokens.get(index);
    }

    /** Returns the next token and moves up the token index. */
    private Token next() throws ParseException {
        Token result = peek();
        index++;
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [text]+");
        } else {
            for (String text : args) {
                CharStream stream = new ANTLRInputStream(text);
                Lexer lexer = new CC4(stream);
                try {
                    System.out.printf("Parse tree: %n%s%n",
                            new CC4Parser().parse(lexer));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
