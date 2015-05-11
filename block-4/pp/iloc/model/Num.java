package pp.iloc.model;

/** Numeric operand.
 * A numeric operand can be a literal or a (symbolic) constant.
 * @author Arend Rensink
 */
public class Num extends Operand {
	/** Constructs a literal numeric operand. */
	public Num(int value) {
		super(Type.NUM);
		this.value = value;
		this.name = null;
	}

	/** Constructs a symbolic numeric operand. */
	public Num(String name) {
		super(Type.NUM);
		assert wellformed(name);
		this.name = name.substring(1);
		this.value = -1;
	}

	/** Indicates if this parameter is a literal value.
	 * If not, it is a named symbolic constant.
	 */
	public boolean isLit() {
		return this.name == null;
	}

	/** Returns the value of this numeric operand, if it is a literal. */
	public int getValue() {
		return this.value;
	}

	private final int value;

	/** Returns the name of this numeric operand, if it is a constant. */
	public String getName() {
		return this.name;
	}

	private final String name;

	@Override
	public String toString() {
		return isLit() ? "" + this.value : '@' + getName();
	}

	@Override
	public int hashCode() {
		return isLit() ? 31 * getValue() : getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Num)) {
			return false;
		}
		Num other = (Num) obj;
		if (isLit() != other.isLit()) {
			return false;
		}
		if (isLit()) {
			if (getValue() != other.getValue()) {
				return false;
			}
		} else {
			if (!getName().equals(other.getName())) {
				return false;
			}
		}
		return true;
	}

	/** Tests if a string value is a well-formed name. */
	private boolean wellformed(String value) {
		if (value == null) {
			return false;
		}
		if (value.isEmpty()) {
			return false;
		}
		if (value.charAt(0) != '@') {
			return false;
		}
		if (!Character.isLetter(value.charAt(1))) {
			return false;
		}
		for (int i = 2; i < value.length(); i++) {
			char c = value.charAt(i);
			if (!(Character.isLetterOrDigit(c) || c == '-' || c == '_')) {
				return false;
			}
		}
		return true;
	}
}