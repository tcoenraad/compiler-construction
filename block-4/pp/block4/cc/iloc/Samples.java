package pp.block4.cc.iloc;

/** Example code snippets for control flow graph generation. */
public class Samples {
	/** Max example used in Block 4. */
	public void max() {
		int[] a = { 0, 2, 4, 1 };
		int max = 0;
		int i = 0;
		while (i < a.length) {
			if (a[i] > max) {
				max = a[i];
			}
			i = i + 1;
		}
		printf("Max: %d%n", max);
	}

	/** Find example used in Block 4. */
	public void find() {
		int[] a = { 0, 2, 4, 1 };
		int x = in();
		int i = 0;
		boolean found = false;
		while (!found && i < a.length) {
			found = (a[i] == x);
			if (!found) {
				i = i + 1;
			}
		}
		printf("Index: %d%n", i);
	}

	/** Find example with break statement, used in Block 4 challenge. */
	public void findBreak() {
		int[] a = { 0, 2, 4, 1 };
		int x = in();
		int i;
		for (i = 0; i < a.length; i++) {
			if (a[i] == x) {
				break;
			}
		}
		printf("Index: %d%n", i);
	}

	/** AddEven example used in Block 4. */
	public void addEven() {
		int up = in();
		int sum = 0;
		for (int i = 0; 
				i < up; 
				i = i + 1) {
			if ((i & 1) == 0) {
				continue;
			}
			sum = sum + i;
		}
		printf("Sum: %d%n", sum);
	}

	private int in() {
		int result;
		String line = System.console().readLine("Input? ");
		try {
			result = Integer.parseInt(line);
		} catch (RuntimeException exc) {
			result = 0;
		}
		return result;
	}

	private void printf(String format, Object... args) {
		System.out.printf(format, args);
	}
}
