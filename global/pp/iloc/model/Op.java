package pp.iloc.model;

import static pp.iloc.model.OpClaz.COMMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ILOC operation
 * @author Arend Rensink
 */
public class Op extends Instr {
	/** Constructs an unlabelled operation with a given opcode and arguments. */
	public Op(OpCode opCode, Operand... args) {
		this(null, opCode, args);
	}

	/** Constructs an unlabelled operation with a given opcode and arguments. */
	public Op(OpCode opCode, List<Operand> args) {
		this(null, opCode, args);
	}

	/** Constructs a labelled operation with a given opcode and arguments. */
	public Op(Label label, OpCode opCode, Operand... args) {
		this(label, opCode, Arrays.asList(args));
	}

	/** Constructs a labelled operation with a given opcode and arguments. */
	public Op(Label label, OpCode opCode, List<Operand> args) {
		if (label != null) {
			super.setLabel(label);
		}
		this.opCode = opCode;
		int sourceCount = opCode.getSourceSig().size();
		int targetCount = opCode.getTargetSig().size();
		assert args.size() == sourceCount + targetCount;
		this.sources = new ArrayList<>(sourceCount);
		for (int i = 0; i < sourceCount; i++) {
			Operand arg = args.get(i);
			assert arg.getType() == opCode.getSourceSig().get(i);
			this.sources.add(arg);
		}
		this.targets = new ArrayList<>(targetCount);
		for (int i = 0; i < targetCount; i++) {
			Operand arg = args.get(sourceCount + i);
			assert arg.getType() == opCode.getTargetSig().get(i);
			this.targets.add(arg);
		}
		this.opnds = new ArrayList<>(args);
	}

	/** Returns the class of operation (normal or control flow). */
	public OpClaz getClaz() {
		return this.opCode.getClaz();
	}

	/** Returns the opcode of this operation. */
	public OpCode getOpCode() {
		return this.opCode;
	}

	private final OpCode opCode;

	/** Returns the list of source arguments. */
	public List<Operand> getSources() {
		return this.sources;
	}

	private final List<Operand> sources;

	/** Returns the list of target arguments. */
	public List<Operand> getTargets() {
		return this.targets;
	}

	private final List<Operand> targets;

	/** Returns the list of all (source + target) operands. */
	public List<Operand> getOpnds() {
		return this.opnds;
	}

	/** Convenience method to retrieve a given operand as {@link Reg}. */
	public Reg reg(int i) {
		return (Reg) this.opnds.get(i);
	}

	/** Convenience method to retrieve a given operand as {@link Str}. */
	public Str str(int i) {
		return (Str) this.opnds.get(i);
	}

	/** Convenience method to retrieve a given operand as {@link Num}. */
	public Num num(int i) {
		return (Num) this.opnds.get(i);
	}

	/** Convenience method to retrieve a given operand as {@link Label}. */
	public Label label(int i) {
		return (Label) this.opnds.get(i);
	}

	private final List<Operand> opnds;

	/** Indicates if this operation has a comment. */
	public boolean hasComment() {
		return getComment() != null;
	}

	/** Returns the optional comment for this operation. */
	public String getComment() {
		return this.comment;
	}

	/** Sets a comment for this operation. */
	public void setComment(String comment) {
		this.comment = comment;
	}

	private String comment;

	@Override
	public int size() {
		return 1;
	}

	@Override
	public Iterator<Op> iterator() {
		return Collections.singleton(this).iterator();
	}

	@Override
	public String prettyPrint(int labelSize, int sourceSize, int targetSize) {
		StringBuilder result = new StringBuilder();
		if (labelSize > 0) {
			result.append(String
					.format("%-" + labelSize + "s", toLabelString()));
		}
		if (getClaz() == COMMENT) {
			result.append(toCommentString());
		} else {
			result.append(String.format("%-8s", getOpCode().name()));
			if (sourceSize > 0) {
				result.append(String.format("%-" + sourceSize + "s ",
						toSourceString()));
			}
			result.append(String.format("%-4s", toArrowString()));
			if (targetSize > 0) {
				result.append(String.format("%-" + targetSize + "s ",
						toTargetString()));
			}
			result.append(toCommentString());
		}
		result.append('\n');
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(toLabelString());
		if (getClaz() != COMMENT) {
			result.append(getOpCode());
			if (!getSources().isEmpty()) {
				result.append(' ');
				result.append(toSourceString());
			}
			if (!getTargets().isEmpty()) {
				result.append(' ');
				result.append(getClaz().getArrow());
				result.append(' ');
				result.append(toTargetString());
			}
			result.append(' ');
		}
		result.append(toCommentString());
		return result.toString();
	}

	/** Returns the string representation of the optional label. */
	String toArrowString() {
		if (getTargets().size() > 0 && getClaz() != COMMENT) {
			return ' ' + getClaz().getArrow() + ' ';
		} else {
			return "";
		}
	}

	/** Returns the string representation of the optional comment. */
	String toCommentString() {
		if (hasComment()) {
			return COMMENT_SEP + getComment();
		} else {
			return "";
		}
	}

	/** Returns the string representation of the source operands. */
	String toSourceString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Operand o : getSources()) {
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
		}
		return result.toString();
	}

	/** Returns the string representation of the target operands. */
	String toTargetString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Operand o : getTargets()) {
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		result = prime * result
				+ ((this.comment == null) ? 0 : this.comment.hashCode());
		result = prime * result + this.opCode.hashCode();
		result = prime * result + this.sources.hashCode();
		result = prime * result + this.targets.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		Op other = (Op) obj;
		if (!hasComment()) {
			if (other.hasComment()) {
				return false;
			}
		} else if (!getComment().equals(other.getComment())) {
			return false;
		}
		if (this.opCode != other.opCode) {
			return false;
		}
		if (!this.sources.equals(other.sources)) {
			return false;
		}
		if (!this.targets.equals(other.targets)) {
			return false;
		}
		return true;
	}

	/** Comment separator. */
	private final static String COMMENT_SEP = "// ";
	/** Operand separator. */
	private final static String OP_SEP = ",";
}
