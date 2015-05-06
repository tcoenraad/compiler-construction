package pp.block2.cc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Lexer;

/**
 * Functionality to retrieve the token names from an Antlr-generated scanner.
 * Uses reflection to investigate the static field names in the scanner class.
 * Use by instantiating {@link #AntlrTokenNames(Class)} with the scanner class as argument.
 * @author Arend Rensink
 */
public class SymbolFactory {
	public SymbolFactory(Class<? extends Lexer> lexer) {
		this.lexer = lexer;
	}

	private final Class<? extends Lexer> lexer;

	/** Returns the list of all detected token names, ordered by index.
	 * This list consists of all {@code public static int}-field names 
	 * from the lexer class that start with an uppercase letter.
	 * @return
	 */
	public List<String> getNames() {
		if (names == null) {
			names = computeNames();
		}
		return names;
	}

	/** The list of token names. */
	private List<String> names;

	/** Computes the list of token names through reflection. */
	private List<String> computeNames() {
		List<String> result = new ArrayList<>();
		for (Field field : lexer.getFields()) {
			if (!Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			if (!Modifier.isPublic(field.getModifiers())) {
				continue;
			}
			// In Antlr 4.4, the token names are given in public static int declarations
			// at the top of the class; as soon as we see a public static field of
			// any other type than int, we're done with the tokens
			if (field.getType() != int.class) {
				break;
			}
			if (!Character.isUpperCase(field.getName().charAt(0))) {
				break;
			}
			try {
				int value = field.getInt(null);
				while (value >= result.size()) {
					result.add(null);
				}
				result.set(value, field.getName());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				assert false;
			}
		}
		return result;
	}

	/** Returns the token name with a given index. */
	public String get(int i) {
		return getNames().get(i);
	}

	/** Returns the list of terminals of the Antlr lexer, wrapped into
	 * {@link Term} objects.
	 */
	public List<Term> getTerminals() {
		if (terms == null) {
			terms = calcTerminals();
		}
		return terms;
	}

	/** Returns the terminal with a given index from the Antlr lexer,
	 * wrapped into a {@link Term} object.
	 */
	public Term getTerminal(int index) {
		return getTerminals().get(index);
	}

	private List<Term> calcTerminals() {
		List<Term> result = new ArrayList<>();
		result.add(null);
		for (int i = 1; i < getNames().size(); i++) {
			result.add(new Term(i, get(i)));
		}
		return result;
	}

	private List<Term> terms;

	/** Main method for testing purposes. 
	 * @param args list of (qualified) names of lexer classes. 
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [ lexer-class-name ]+");
		}
		for (String name : args) {
			try {
				// find the lexer class of this name
				Class<?> lexer = ClassLoader.getSystemClassLoader().loadClass(
						name);
				// check if it really extends the Lexer superclass from Antlr
				if (Lexer.class.isAssignableFrom(lexer)) {
					@SuppressWarnings("unchecked")
					List<String> names = new SymbolFactory(
							(Class<? extends Lexer>) lexer).getNames();
					System.out.printf(
							"Token types in %s (ordered by type number): %s%n",
							name, names.subList(1, names.size()));
				} else {
					System.err.printf(
							"Class %s is not an Antlr-generated lexer class%n",
							name);
				}
			} catch (ClassNotFoundException e) {
				System.err.printf("No such class %s%n", name);
			}
		}
	}
}
