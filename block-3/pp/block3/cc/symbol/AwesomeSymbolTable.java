package pp.block3.cc.symbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AwesomeSymbolTable implements SymbolTable {
    private List<Set<String>> symbolList;

    public AwesomeSymbolTable() {
        symbolList = new ArrayList<>();
        symbolList.add(new HashSet<>());
    }

    public int getLevel() {
        return symbolList.size() - 1;
    }

    @Override
    public void openScope() {
        symbolList.add(new HashSet<>());
    }

    @Override
    public void closeScope() {
        if (getLevel() == 0) {
            throw new RuntimeException("Cannot close outer scope");
        }
        symbolList.remove(getLevel());
    }

    @Override
    public boolean add(String id) {
        return symbolList.get(getLevel()).add(id);
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
