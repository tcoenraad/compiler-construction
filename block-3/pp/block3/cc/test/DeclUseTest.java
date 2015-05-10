package pp.block3.cc.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import pp.block3.cc.symbol.DeclUse;
import pp.block3.cc.symbol.DeclUseLexer;
import pp.block3.cc.symbol.DeclUseParser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeclUseTest {
    private final DeclUse declUse = new DeclUse();
    private final ParseTreeWalker walker = new ParseTreeWalker();

    @Test
    public void test() {
        testDeclUse(new ArrayList<>(), "(D:aap (U:aap) U:aap)");
        testDeclUse(new ArrayList<>(), "(D:aap (U:aap (U:aap)) U:aap)");

        List<String> errors = new ArrayList<>();
        errors.add("Error on line 1, pos 3");
        errors.add("Error on line 1, pos 23");
        errors.add("Error on line 1, pos 30");
        testDeclUse(new ArrayList<>(errors), "(U:aap (D:aap U:aap) U:aap (U:aap))");
    }

    private void testDeclUse(List<String> expected, String input) {
        ParseTree tree = parseDeclUse(input);
        walker.walk(declUse, tree);
        assertEquals(expected, declUse.getErrors());
    }

    private ParseTree parseDeclUse(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new DeclUseLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        DeclUseParser parser = new DeclUseParser(tokens);
        return parser.program();
    }
}
