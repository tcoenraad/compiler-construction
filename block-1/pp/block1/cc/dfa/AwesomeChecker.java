package pp.block1.cc.dfa;

public class AwesomeChecker implements Checker {
    public boolean accepts(State start, String word) {
        State state = start;
        for (int i = 0; i < word.length() && state != null; i++) {
            state = state.getNext(word.charAt(i));
        }
        return (state != null) ? state.isAccepting() : false;
    }
}
