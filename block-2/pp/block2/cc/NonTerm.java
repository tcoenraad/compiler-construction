package pp.block2.cc;

/** 
 * Non-terminal symbol in a grammar.
 * @author Arend Rensink
 */
public class NonTerm implements Symbol {
	/** Constructs a non-terminal with a given name. */
	public NonTerm(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	private final String name;

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof NonTerm)) {
			return false;
		}
		NonTerm other = (NonTerm) obj;
		return name.equals(other.name);
	}
}
