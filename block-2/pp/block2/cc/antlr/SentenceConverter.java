package pp.block2.cc.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.block2.cc.*;

/**
 * Created by Jip on 3-5-2015.
 */
public class SentenceConverter extends SentenceBaseListener implements Parser {
    private AST result;
    private AST current;
    private String message;
    private boolean failed;

    @Override
    public AST parse(Lexer lexer) throws ParseException {
        result = null;
        failed = false;
        SentenceParser parser = new SentenceParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.sentence();
        new ParseTreeWalker().walk(this, tree);
        if(failed){
            throw new ParseException(message);
        }
        return result;

    }
    @Override
    public void enterSentence(SentenceParser.SentenceContext ctx) {
        result = (new AST(new NonTerm("Sentence")));
        current = result;
    }

    @Override
    public void enterSubject(SentenceParser.SubjectContext ctx) {
        AST subj = new AST(new NonTerm("Subject"));
        int i = result.getChildren().size();
        current.addChild(subj);
        current = current.getChildren().get(i);
    }

    @Override
    public void enterModifier(SentenceParser.ModifierContext ctx) {
        AST subj = new AST(new NonTerm("Modifier"));
        int i = current.getChildren().size();
        current.addChild(subj);
        current = current.getChildren().get(i);
    }

    @Override
    public void enterObject(SentenceParser.ObjectContext ctx) {
        AST subj = new AST(new NonTerm("Object"));
        int i = current.getChildren().size();
        current.addChild(subj);
        current = current.getChildren().get(i);
    }
    @Override
    public void exitSentence(SentenceParser.SentenceContext ctx) {
    }

    @Override
    public void exitSubject(SentenceParser.SubjectContext ctx) {
        current = goOneUp(result, goOneUp(result, current));
    }

    @Override
    public void exitModifier(SentenceParser.ModifierContext ctx) {
    }

    @Override
    public void exitObject(SentenceParser.ObjectContext ctx) {
        current = goOneUp(result, current);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        Term t = new Term(node.getSymbol().getType(), findText(node.getText()));
        current.addChild(new AST(t, node.getSymbol()));
        current = goOneUp(result, current);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        failed = true;
        message = "Last error node: " + node.getText();
    }

    private AST goOneUp(AST res, AST old){
        if(res.equals(old)){
            return res;
        }
        if(res.getChildren()!=null){
            for(int i=res.getChildren().size()-1; i>=0; i--){
                if(res.getChildren() != null && res.getChildren().get(i)!=null && res.getChildren().get(i).equals(old)){
                    return res;
                } else if(goOneUp(res.getChildren().get(i), old)!= null) {
                    return goOneUp(res.getChildren().get(i), old);
                }

            }
        }
        return null;
    }

    //Dit is niet netjes, maar weet geen andere oplossing, wat een rotcode =(
    private String findText(String t){
        if(t.equals("love")) {
            return "VERB";
        } else if(t.equals("students") || t.equals("compilers")){
            return "NOUN";
        } else if(t.equals(".")){
            return "ENDMARK";
        } else if(t.equals("all") || t.equals("undergraduate") || t.equals("smart")){
            return "ADJECTIVE";
        } else{
            return "UNKNOWN";
        }
    }


}
