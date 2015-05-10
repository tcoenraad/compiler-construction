package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.List;

public class DeclUse extends DeclUseBaseListener {

    private final SymbolTable symbolTable;
    private List<String> errors;

    public DeclUse() {
        symbolTable = new AwesomeSymbolTable();
        errors = new ArrayList<>();
    }

    @Override
    public void enterSeries(DeclUseParser.SeriesContext ctx) {
        symbolTable.openScope();
    }

    @Override
    public void exitSeries(DeclUseParser.SeriesContext ctx) {
        symbolTable.closeScope();
    }

    @Override
    public void enterDecl(DeclUseParser.DeclContext ctx) {
        symbolTable.add(ctx.getText().substring(2));
    }


    @Override
    public void enterUse(DeclUseParser.UseContext ctx) {
        if (!symbolTable.contains(ctx.getText().substring(2))) {
            errors.add(String.format("Error on line %s, pos %s", ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine()));
        }
    }
    
    public List<String> getErrors() {
        return errors;
    }
}
