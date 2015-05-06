package pp.block2.cc;

/** Supertype of (terminal and non-terminal) grammar symbols. */
public interface Symbol {
	/** Returns the name of this symbol. */
	public String getName();

	/** Special terminal for the empty string. */
	public static final Term EMPTY = new Term("EMPTY");
	/** Special terminal for the end-of-file token. */
	public static final Term EOF = new Term("EOF");
}
