package pp.block3.cc.tabular;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class LaTeXTable2HTML extends TabularBaseListener {
    private AwesomeErrorListener errorListener;
    private StringBuilder html;

    public LaTeXTable2HTML(AwesomeErrorListener errorListener) {
        this.errorListener = errorListener;
        this.html = new StringBuilder();
    }

    @Override
    public void enterTable(TabularParser.TableContext ctx) {
        html.append("<html><body><table style='border: 1px solid black;'");
    }
    @Override
    public void exitTable(TabularParser.TableContext ctx) {
        html.append("</table></body></html>");
    }
    @Override
    public void enterRow(TabularParser.RowContext ctx) {
        html.append("<tr>");
    }
    @Override
    public void exitRow(TabularParser.RowContext ctx) {
        html.append("</tr>");
    }
    @Override
    public void enterCell(TabularParser.CellContext ctx) {
        html.append("<td>");
        html.append(ctx.getText());
    }
    @Override
    public void exitCell(TabularParser.CellContext ctx) {
        html.append("</td>");
    }

    private static LaTeXTable2HTML convertLaTeX2HTML(String text) {
        AwesomeErrorListener errorListener = new AwesomeErrorListener();
        LaTeXTable2HTML latexTable2HTML = new LaTeXTable2HTML(errorListener);

        CharStream chars = new ANTLRInputStream(text);

        Lexer lexer = new TabularLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        TokenStream tokens = new CommonTokenStream(lexer);

        TabularParser parser = new TabularParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        new ParseTreeWalker().walk(latexTable2HTML, parser.table());

        return latexTable2HTML;
    }

    public List<String> getErrorList() {
        return errorListener.getErrorList();
    }

    public String getHTML() {
        return html.toString();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("USAGE: <file.tex> [<file.html>]");
            System.exit(0);
        }

        String file = "";
        try {
            file = new String(readAllBytes(get(args[0])));
        }  catch (IOException e) {
            System.err.println("Error occurred while loading tex file");
            System.exit(0);
        }

        LaTeXTable2HTML latexTable2HTML = convertLaTeX2HTML(file);

        List<String> errors = latexTable2HTML.getErrorList();
        if (errors.size() == 0) {
            if (args.length == 1) {
                System.out.println(latexTable2HTML.getHTML());
            }
            else if (args.length > 1) {
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(args[1]);
                } catch (FileNotFoundException e) {
                    System.err.println("Error occurred while writing HTML file");
                }
                writer.print(latexTable2HTML.getHTML());
                writer.close();
            }
        } else {
            errors.stream().forEach(error -> System.out.println(error));
        }
    }
}
