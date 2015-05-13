package pp.block3.cc.symbol;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AwesomeSymbolTable implements SymbolTable {
    private Stack<Set<String>> symbolList;

    public AwesomeSymbolTable() {
        symbolList = new Stack<>();
        symbolList.push(new HashSet<>());
    }

    public int getLevel() {
        return symbolList.size() - 1;
    }

    @Override
    public void openScope() {
        symbolList.push(new HashSet<>());
    }

    @Override
    public void closeScope() {
        if (getLevel() == 0) {
            throw new RuntimeException("Cannot close outer scope");
        }
        symbolList.pop();
    }

    @Override
    public boolean add(String id) {
        return symbolList.peek().add(id);
    }

    @Override
    public boolean contains(String id) {
        for (int i = 0; i <= getLevel(); i++) {
            if (symbolList.get(i).contains(id)) {
                return true;
            }
        }
        return false;
    }
}
