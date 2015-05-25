package pp.iloc.model;

import static pp.iloc.model.OpClaz.COMMENT;
import static pp.iloc.model.OpClaz.CONTROL;
import static pp.iloc.model.OpClaz.NORMAL;
import static pp.iloc.model.Operand.Type.LABEL;
import static pp.iloc.model.Operand.Type.NUM;
import static pp.iloc.model.Operand.Type.REG;
import static pp.iloc.model.Operand.Type.STR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code defining the type of a (non-control flow) operation.
 * @author Arend Rensink
 */
public enum OpCode {
	// Placeholder
	/** Placeholder. */
	nop(0),

	// Register arithmetic
	/** Addition (reg + reg => reg). */
	add(2, REG, REG, REG),
	/** Subtraction (reg - reg => reg). */
	sub(2, REG, REG, REG),
	/** Multiplication (reg * reg => reg). */
	mult(2, REG, REG, REG),
	/** Division (reg / reg => reg). */
	div(2, REG, REG, REG),

	// Immediate arithmetic
	/** Addition (reg + num => reg). */
	addI(2, REG, NUM, REG),
	/** Subtraction (reg - num => reg). */
	subI(2, REG, NUM, REG),
	/** Subtraction (num - reg => reg). */
	rsubI(2, REG, NUM, REG),
	/** Multiplication (reg * num => reg). */
	multI(2, REG, NUM, REG),
	/** Division (reg / num => reg). */
	divI(2, REG, NUM, REG),
	/** Division (num / reg => reg). */
	rdivI(2, REG, NUM, REG),

	// Shifts (register + immediate)
	/** Left-shift (reg << reg => reg). */
	lshift(2, REG, REG, REG),
	/** Left-shift (reg << num => reg). */
	lshiftI(2, REG, NUM, REG),
	/** Right-shift (reg >> reg => reg). */
	rshift(2, REG, REG, REG),
	/** Right-shift (reg >> num => reg). */
	rshiftI(2, REG, NUM, REG),

	// Other bit operations
	/** Bitwise OR (reg | reg => reg). */
	or(2, REG, REG, REG),
	/** Bitwise or (reg | num => reg). */
	orI(2, REG, NUM, REG),
	/** Bitwise AND (reg & reg => reg). */
	and(2, REG, REG, REG),
	/** Bitwise AND (reg & num => reg). */
	andI(2, REG, NUM, REG),
	/** Bitwise XOR (reg ^ reg => reg). */
	xor(2, REG, REG, REG),
	/** Bitwise XOR (reg ^ num => reg). */
	xorI(2, REG, NUM, REG),

	// Memory operations
	/** Immediat load (reg => reg). */
	loadI(1, NUM, REG),
	/** Load (reg => reg). */
	load(1, REG, REG),
	/** Load (reg + num => reg). */
	loadAI(2, REG, NUM, REG),
	/** Load (reg + reg => reg). */
	loadAO(2, REG, REG, REG),
	/** Character load (reg => reg). */
	cload(1, REG, REG),
	/** Character load (reg + num => reg). */
	cloadAI(2, REG, NUM, REG),
	/** Character load (reg + reg => reg). */
	cloadAO(2, REG, REG, REG),
	/** Store (reg => reg). */
	store(1, REG, REG),
	/** Store (reg => reg + num). */
	storeAI(1, REG, REG, NUM),
	/** Store (reg => reg + reg). */
	storeAO(1, REG, REG, REG),
	/** Character store (reg => reg). */
	cstore(1, REG, REG),
	/** Character store (reg => reg + num). */
	cstoreAI(1, REG, REG, NUM),
	/** Character store (reg => reg + reg). */
	cstoreAO(1, REG, REG, REG),

	// Copy operations
	/** Integer-to-integer copy (reg => reg). */
	i2i(1, REG, REG),
	/** Character-to-character copy (reg => reg). */
	c2c(1, REG, REG),
	/** Character-to-integer conversion (reg => reg). */
	c2i(1, REG, REG),
	/** Integer-to-character conversion (reg => reg). */
	i2c(1, REG, REG),

	// Comparison operations
	/** Less-than comparison (reg < reg => reg). */
	cmp_LT(2, REG, REG, REG),
	/** Less-or-equal comparison (reg <= reg => reg). */
	cmp_LE(2, REG, REG, REG),
	/** Equals comparison (reg == reg => reg). */
	cmp_EQ(2, REG, REG, REG),
	/** Greater-or-equal comparison (reg >= reg => reg). */
	cmp_GE(2, REG, REG, REG),
	/** Greater-than comparison (reg > reg => reg). */
	cmp_GT(2, REG, REG, REG),
	/** Not-equals comparison (reg != reg => reg). */
	cmp_NE(2, REG, REG, REG),

	// Jump operations
	/** Conditional branch. */
	cbr(CONTROL, 1, REG, LABEL, LABEL),
	/** Immediate jump. */
	jumpI(CONTROL, 0, LABEL),
	/** Register jump. */
	jump(CONTROL, 0, REG),
	/** Pseudo-op to record labels of a register jump. */
	tbl(2, REG, LABEL),

	// Extra ops for stack manipulation
	/** Push the value of a register onto the stack. */
	push(1, REG),
	/** Pop the stack top into a register. */
	pop(0, REG),
	// Extra ops for simulation and debugging
	/** Value input (str => reg). */
	in(1, STR, REG),
	/** Value output (str, reg =>). */
	out(2, STR, REG),
	/** Stand-alone program comment; effect = nop. */
	comment(COMMENT, 0);


	/** The class that this opcode falls into. */
	private final OpClaz claz;

	/** The source operand types. */
	private final List<Operand.Type> sourceSig;

	/** The target operand types. */
	private final List<Operand.Type> targetSig;

	private OpCode(int sourceCount, Operand.Type... sig) {
		this(NORMAL, sourceCount, sig);
	}

	private OpCode(OpClaz claz, int sourceCount, Operand.Type... sig) {
		this.claz = claz;
		this.sourceSig = new ArrayList<>(sourceCount);
		for (int i = 0; i < sourceCount; i++) {
			this.sourceSig.add(sig[i]);
		}
		this.targetSig = new ArrayList<>(sig.length - sourceCount);
		for (int i = sourceCount; i < sig.length; i++) {
			this.targetSig.add(sig[i]);
		}
	}

	/** Returns the class of this opcode (normal or control flow). */
	public OpClaz getClaz() {
		return this.claz;
	}

	/** Returns the list of expected source operand types. */
	public List<Operand.Type> getSourceSig() {
		return this.sourceSig;
	}

	/** Returns the list of expected target operand types. */
	public List<Operand.Type> getTargetSig() {
		return this.targetSig;
	}

	/** Returns the {@link OpCode} for a given string, if any. */
	public static OpCode parse(String code) {
		return codeMap.get(code);
	}

	private static final Map<String, OpCode> codeMap = new HashMap<>();
	static {
		for (OpCode op : values()) {
			if (op.getClaz() != OpClaz.COMMENT) {
				codeMap.put(op.name(), op);
			}
		}
	}
}
