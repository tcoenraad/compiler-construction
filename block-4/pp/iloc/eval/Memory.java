package pp.iloc.eval;

import java.util.ArrayList;
import java.util.List;

/** Simulated memory. */
public class Memory {
	private final List<Byte> mem = new ArrayList<>(0);

	/** Sets a location in memory to a given value. */
	public void set(int loc, byte value) {
		while (loc >= this.mem.size()) {
			this.mem.add((byte) 0);
		}
		this.mem.set(loc, value);
	}

	/** 
	 * Returns the value at a given memory location.
	 * The value is 0 if the location was never accessed before. 
	 */
	public byte get(int loc) {
		while (loc >= this.mem.size()) {
			this.mem.add((byte) 0);
		}
		return this.mem.get(loc);
	}

	/** Returns the size of the used memory. */
	public int size() {
		return this.mem.size();
	}

	/** Removes all values from the memory. */
	public void clear() {
		this.mem.clear();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < this.mem.size(); i++) {
			if (result.length() > 0) {
				result.append(", ");
			}
			result.append(i);
			result.append("=");
			result.append(this.mem.get(i));
		}
		return result.toString();
	}
}
