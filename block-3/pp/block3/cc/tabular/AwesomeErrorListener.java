package pp.block3.cc.tabular;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class AwesomeErrorListener extends BaseErrorListener {
    private List<String> errorList;

    public AwesomeErrorListener() {
        errorList = new ArrayList<>();
    }

    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errorList.add(String.format("line %s:%s %s", line, charPositionInLine, msg));
    }

    public List<String> getErrorList() {
        return errorList;
    }
}
