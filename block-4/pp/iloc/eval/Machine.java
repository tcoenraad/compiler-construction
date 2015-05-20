package pp.iloc.eval;

import java.util.HashMap;
import java.util.Map;

import pp.iloc.model.Num;
import pp.iloc.model.Reg;

/**
 * Virtual machine for ILOC program evaluation.
 * @author Arend Rensink
 */
public class Machine {
	/** Size of an integer values (in bytes). */
	public static final int INT_SIZE = 4;
	/** Size of an integer values (in bits). */
	public static final int BYTE_SIZE = 8;
	/** Mapping from register names to register numbers. */
	private final Map<String, Integer> registers;
	/** Mapping from symbolic constants to actual values. */
	private final Map<String, Integer> constants;
	/** Memory of the machine. */
	private final Memory memory;

	private int pc;

	/** Constructs a new, initially empty machine. */
	public Machine() {
		this.constants = new HashMap<>();
		this.memory = new Memory();
		this.registers = new HashMap<>();
	}

	/** Reserves a memory segment of given length.
	 * @param length (in bytes) of the segment to be reserved
	 * @return the base address of the allocated block
	 * @see #alloc(String, int)
	 */
	public int alloc(int length) {
		int result = this.memory.size();
		for (int i = 0; i < length; i++) {
			this.memory.set(result + i, (byte) 0);
		}
		return result;
	}

	/** Reserves a memory segment of given length and
	 * assigns the base address to a symbolic constant.
	 * @return the base address of the allocated block
	 * @see #alloc(String, int)
	 */
	public int alloc(Num num, int length) {
		if (num.isLit()) {
			throw new IllegalArgumentException("Can't allocate to literal '"
					+ num + "'");
		}
		return alloc(num.getName(), length);
	}

	/** Reserves a memory segment of a given length (in bytes),
	 * assigns the base address to a symbolic constant,
	 * and returns the base address.
	 * The reserved memory is guaranteed to be unshared and
	 * initialized to 0.
	 * @param cst the name for the start address of the allocated memory
	 * @param length length (in bytes) of the segment to be reserved
	 * @return the allocated start address
	 * @throws IllegalArgumentException if the symbolic name is known
	 */
	public int alloc(String cst, int length) {
		if (this.constants.get(cst) != null) {
			throw new IllegalArgumentException("Duplicate symbolic name '"
					+ cst + "'");
		}
		int result = alloc(length);
		setNum(cst, result);
		return result;
	}

	/** Initializes a memory segment of a length sufficient to
	 * accommodate a given list of initial values,
	 * assigns the start address to a symbolic name,
	 * and returns the start address.
	 * The reserved memory is guaranteed to be unshared.
	 * @param cst the name for the start address of the allocated memory
	 * @param vals the initial values 
	 * @return the allocated start address
	 * @throws IllegalArgumentException if the symbolic name is known
	 */
	public int init(String cst, int... vals) {
		if (this.constants.get(cst) != null) {
			throw new IllegalArgumentException("Duplicate symbolic name '"
					+ cst + "'");
		}
		int result = this.memory.size();
		setNum(cst, result);
		for (int i = 0; i < vals.length; i++) {
			store(vals[i], result + INT_SIZE * i);
		}
		return result;
	}

	/** Declares a register with a given name, and sets its value to 0. */
	public void declare(String reg) {
		setReg(reg, 0);
	}

	/** Sets the value of a register with a given name to a given number. */
	public void setReg(String reg, int val) {
		this.registers.put(reg, val);
	}

	/** Returns the current value in a given register. */
	public int getReg(Reg reg) {
		return getReg(reg.getName());
	}

	/** Returns the current value in a register with a given name.
	 * @throws IllegalArgumentException if no such register exists */
	public int getReg(String name) {
		Integer result = this.registers.get(name);
		if (result == null) {
			throw new IllegalArgumentException("Unknown register '" + name
					+ "'");
		}
		return result;
	}

	/** Sets the value of a given register to a given number. */
	public void setReg(Reg reg, int val) {
		this.registers.put(reg.getName(), val);
	}

	/** Sets the value of a given named symbolic constant.
	 * @throws IllegalArgumentException if the name is already declared 
	 */
	public void setNum(String name, int val) {
		Integer oldVal = this.constants.put(name, val);
		if (oldVal != null) {
			throw new IllegalArgumentException("Duplicate constant '" + name
					+ "': values " + oldVal + " and " + val);
		}
	}

	/** Returns the value of a given {@link Num} operand.
	 * This can be either a literal or a symbolic constant.
	 * @throws IllegalArgumentException if the num is not declared 
	 */
	public int getNum(Num num) {
		return num.isLit() ? num.getValue() : getNum(num.getName());
	}

	/** Returns the value of a given symbolic constant.
	 * @throws IllegalArgumentException if the name is not declared 
	 */
	public int getNum(String name) {
		Integer result = this.constants.get(name);
		if (result == null) {
			throw new IllegalArgumentException("Unknown constant '" + name
					+ "'");
		}
		return result;
	}

	/** Returns the integer value starting at a given memory location.
	 * The value is computed from the four successive bytes starting
	 * at that location (most significant first).
	 */
	public int load(int loc) {
		int result = 0;
		for (int i = 0; i < INT_SIZE; i++) {
			result <<= BYTE_SIZE;
			result += 0xFF & this.memory.get(loc + i);
		}
		return result;
	}

	/** Stores an integer value in memory, starting at a given location.
	 * The value is stored at the four successive bytes starting
	 * at that location (most significant first).
	 */
	public void store(int val, int loc) {
		for (int i = INT_SIZE; i > 0; i--) {
			this.memory.set(loc + i - 1, (byte) val);
			val >>= BYTE_SIZE;
		}
	}

	/** Returns the current program counter value. */
	public int getPC() {
		return this.pc;
	}

	/** Increases the current program counter value. */
	public void incPC() {
		this.pc++;
	}

	/** sets the program counter to a given line number. */
	public void setPC(int line) {
		this.pc = line;
	}

	/** Clears the registers, constants, memory and PC. */
	public void clear() {
		this.registers.clear();
		this.constants.clear();
		this.memory.clear();
		this.pc = 0;
	}

	@Override
	public String toString() {
		return String.format("Registers: %s%nConstants: %s%nMemory: %s%n",
				this.registers, this.constants, this.memory);
	}
}
