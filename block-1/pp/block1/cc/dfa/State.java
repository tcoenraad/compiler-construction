package pp.block1.cc.dfa;

import java.util.Map;
import java.util.TreeMap;

/**
 * State of a DFA.
 */
public class State {
	/**
	 * Constructs a new, possibly accepting state with a given number. The
	 * number is meant to identify the state, but there is no check for
	 * uniqueness.
	 */
	public State(int nr, boolean accepting) {
		this.next = new TreeMap<>();
		this.nr = nr;
		this.accepting = accepting;
	}

	/** Returns the state number. */
	public int getNumber() {
		return nr;
	}

	/** State number */
	private final int nr;

	/** Indicates if the state is accepting. */
	public boolean isAccepting() {
		return accepting;
	}

	/** Flag indicating if this state is accepting. */
	private final boolean accepting;

	/**
	 * Adds an outgoing transition to a next state. This overrides any previous
	 * transition for that character.
	 */
	public void addNext(Character c, State next) {
		this.next.put(c, next);
	}

	/** Indicates if there is a next state for a given character. */
	public boolean hasNext(Character c) {
		return getNext(c) != null;
	}

	/**
	 * Returns the (possibly <code>null</code>) next state for a given
	 * character.
	 */
	public State getNext(Character c) {
		return next.get(c);
	}

	/** Mapping to next states. */
	private final Map<Character, State> next;

	@Override
	public String toString() {
		String trans = "";
		for (Map.Entry<Character, State> out : next.entrySet()) {
			if (!trans.isEmpty()) {
				trans += ", ";
			}
			trans += "--" + out.getKey() + "-> " + out.getValue().getNumber();
		}
		return String.format("State %d (%s) with outgoing transitions %s", nr,
				accepting ? "accepting" : "not accepting", trans);
	}

	static final public State ID6_DFA;
	static {
		ID6_DFA = new State(0, false);
		State id61 = new State(1, false);
		State id62 = new State(2, false);
		State id63 = new State(3, false);
		State id64 = new State(4, false);
		State id65 = new State(5, false);
		State id66 = new State(5, true);
		State[] states = { ID6_DFA, id61, id62, id63, id64, id65, id66 };
		for (char c = 'a'; c < 'z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = 'A'; c < 'Z'; c++) {
			for (int s = 0; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
		for (char c = '0'; c < '9'; c++) {
			for (int s = 1; s < states.length - 1; s++) {
				states[s].addNext(c, states[s + 1]);
			}
		}
	}

    static final public State DFA_LALA;
    static {
        DFA_LALA = new State(0, false);
        State lala1 = new State(1, false);
        State lala2 = new State(2, true);
        State lala3 = new State(3, true);
        State lala4 = new State(4, false);
        State lala5 = new State(5, true);
        State lala6 = new State(6, true);
        State lala7 = new State(7, false);
        State lala8 = new State(8, false);
        State lala9 = new State(9, true);
        State lala10 = new State(10, false);
        State lala11 = new State(11, true);
        State lala12 = new State(12, true);

        State[] states = { DFA_LALA, lala1, lala2, lala3, lala4, lala5, lala6, lala7, lala8, lala9, lala10, lala11, lala12 };
        states[0].addNext('L', states[1]);
        states[1].addNext('a', states[2]);
        states[2].addNext('a', states[2]);
        states[2].addNext(' ', states[3]);
        states[2].addNext('L', states[4]);
        states[3].addNext('L', states[4]);
        states[3].addNext(' ', states[3]);
        states[4].addNext('a', states[5]);
        states[5].addNext('a', states[5]);
        states[5].addNext(' ', states[6]);
        states[5].addNext('L', states[7]);
        states[6].addNext('L', states[7]);
        states[6].addNext(' ', states[6]);
        states[7].addNext('a', states[8]);
        states[8].addNext(' ', states[9]);
        states[8].addNext('L', states[10]);
        states[9].addNext('L', states[10]);
        states[9].addNext(' ', states[9]);
        states[10].addNext('i', states[11]);
        states[11].addNext(' ', states[12]);
        states[12].addNext(' ', states[12]);
    }
}
