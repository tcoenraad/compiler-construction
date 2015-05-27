package pp.iloc.eval;

import java.util.Arrays;

/** Simulated memory. */
public class Memory {
	/** The default size of the memory, in number of bytes. */
	public final static int DEFAULT_SIZE = 10000;
	/** The memory array. */
	private byte[] mem = new byte[DEFAULT_SIZE];

	/** Reinitialises the memory to a certain size. */
	public void setSize(int size) {
		this.mem = new byte[size];
	}

	/** Sets a location in memory to a given value. */
	public void set(int loc, byte value) {
		this.mem[loc] = value;
	}

	/** 
	 * Returns the value at a given memory location.
	 * The value is 0 if the location was never accessed before. 
	 */
	public byte get(int loc) {
		return this.mem[loc];
	}

	/** Returns the size of the used memory. */
	public int size() {
		return this.mem.length;
	}

	/** Removes all values from the memory. */
	public void clear() {
		Arrays.fill(this.mem, (byte) 0);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size(); i++) {
			if (get(i) == 0) {
				continue;
			}
			if (result.length() > 0) {
				result.append(", ");
			}
			result.append(i);
			result.append(":");
			result.append(String.format("%02X", get(i) & 0xFF));
		}
		return result.toString();
	}
}
