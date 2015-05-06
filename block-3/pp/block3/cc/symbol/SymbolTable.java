package pp.block3.cc.symbol;

/** Store and tests for nested scopes of variable declarations.
 * A newly constructed {@link SymbolTable} should consist of a single
 * (outer) scope. 
 */
public interface SymbolTable {
	/** Adds a next deeper scope level. */
	public abstract void openScope();

	/** Removes the deepest scope level.
	 * @throws RuntimeException if the table only contains the outer scope.
	 */
	public abstract void closeScope();

	/** Tries to declare a given identifier in the deepest scope level.
	 * @return <code>true</code> if the identifier was added,
	 * <code>false</code> if it was already declared in this scope.
	 */
	public abstract boolean add(String id);

	/** Tests if a given identifier is in the scope of any declaration.
	 * @return <code>true</code> if there is any enclosing scope in which
	 * the identifier is declared; <code>false</code> otherwise.
	 */
	public abstract boolean contains(String id);
}
