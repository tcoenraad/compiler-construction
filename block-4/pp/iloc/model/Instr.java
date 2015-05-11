package pp.iloc.model;

import java.util.Iterator;

/**
 * ILOC instruction
 * @author Arend Rensink
 */
public abstract class Instr implements Iterable<Op> {
	/** Returns the number of operations in this instruction. */
	public abstract int size();

	/** Returns an iterator over the operations in this instruction. */
	@Override
	public abstract Iterator<Op> iterator();

	/** Indicates if the line number of this instruction has been set. */
	public boolean hasLine() {
		return getLine() >= 0;
	}

	/** Returns the line number of this instruction.
	 * @return the line number; {@code -1} if the line number has not been set.
	 */
	public int getLine() {
		return this.line;
	}

	/** Sets the line number of this instruction. */
	public void setLine(int line) {
		assert this.line < 0 && line >= 0;
		this.line = line;
	}

	private int line = -1;
	/** Indicates if this instruction has a (non-<code>null</code>) label. */
	public boolean hasLabel() {
		return getLabel() != null;
	}

	/** Returns the optional label of this instruction. */
	public Label getLabel() {
		return this.label;
	}

	/** Sets the optional label of this instruction. */
	public void setLabel(Label label) {
		assert this.label == null & label != null;
		this.label = label;
	}

	/** Returns the string representation of the optional label. */
	String toLabelString() {
		if (hasLabel()) {
			return getLabel() + LABEL_SEP;
		} else {
			return "";
		}
	}

	private Label label;

	/** Returns a string of the form
	 * {@code label? opCode sources (arrow targets)? comment?}
	 * where the widths of the label, sources and targets parts
	 * are predetermined.
	 * @param labelSize width of the {@code label} part
	 * @param sourceSize width of the {@code sources} part
	 * @param targetSize width of the {@code targets} part
	 */
	abstract public String prettyPrint(int labelSize, int sourceSize,
			int targetSize);

	@Override
	public int hashCode() {
		return (this.label == null) ? 0 : this.label.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Instr)) {
			return false;
		}
		Instr other = (Instr) obj;
		if (this.label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!this.label.equals(other.label)) {
			return false;
		}
		return true;
	}

	/** Label separator. */
	private final static String LABEL_SEP = ": ";
}
