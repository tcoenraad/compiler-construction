package pp.block2.cc.ll;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import pp.block2.cc.*;

import java.util.List;

import static pp.block2.cc.ll.CC4.*;


/**
 * Created by Jip on 2-5-2015.
 */
public class CC4Parser implements Parser {
    private static final NonTerm L = new NonTerm("L");
    private static final NonTerm R = new NonTerm("R");
    private static final NonTerm Q = new NonTerm("Q");
    private static final NonTerm R2 = new NonTerm("R2");
    private static final NonTerm Q2 = new NonTerm("Q2");
    public CC4Parser() {
        this.fact = new SymbolFactory(CC4.class);
    }

    private final SymbolFactory fact;

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        this.tokens = lexer.getAllTokens();
        this.index = 0;
        return parseL();
    }

    private List<? extends Token> tokens;

    private AST parseL() throws ParseException {
        AST result = new AST(L);
        // there is only one rule, no need to look at token
        Token next = peek();
        switch(next.getType()){
            case A:
                result.addChild(parseR());
                result.addChild(parseToken(A));
                break;
            case B:
                result.addChild(parseQ());
                result.addChild(parseToken(B));
                result.addChild(parseToken(A));
                break;
            case C:
                result.addChild(parseR());
                result.addChild(parseToken(A));
                break;
            default:
                System.out.println("Mijn type is: " + next.getType());
                throw unparsable(L);

        }
        return result;
    }

    private AST parseR() throws ParseException {
        AST result = new AST(R);
        Token next = peek();
        switch (next.getType()) {
            case A:
                result.addChild(parseToken(A));
                result.addChild(parseToken(B));
                result.addChild(parseToken(A));
                result.addChild(parseR2());
                break;
            case C:
                result.addChild(parseToken(C));
                result.addChild(parseToken(A));
                result.addChild(parseToken(B));
                result.addChild(parseToken(A));
                result.addChild(parseR2());
                break;
            default:
                throw unparsable(R);

        }
        return result;
    }

    private AST parseQ() throws ParseException {
        AST result = new AST(Q);
        // choose between rules based on the lookahead
        result.addChild(parseToken(B));
        result.addChild(parseQ2());
        return result;
    }


    private AST parseR2() throws ParseException {
        AST result = new AST(R2);
        Token next = peek();
        if(next != null){
            System.out.println(next.getType());
            switch (next.getType()){
                case B:
                    result.addChild(parseToken(B));
                    result.addChild(parseToken(C));
                    result.addChild(parseR2());
                    break;
                case A:
                    break;
                default:
                    throw unparsable(R2);
            }
        }

        return result;
    }

    private AST parseQ2() throws ParseException {
        AST result = new AST(Q2);
        Token next = peek();
        switch(next.getType()){
            case B:
                result.addChild(parseToken(B));
                result.addChild(parseToken(C));
                break;
            case C:
                result.addChild(parseToken(C));
                break;
            default:
                throw unparsable(Q2);
        }
        return result;
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

    private int index;


    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [text]+");
        } else {
            for (String text : args) {
                System.out.println("Tekst is: " + text);
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
