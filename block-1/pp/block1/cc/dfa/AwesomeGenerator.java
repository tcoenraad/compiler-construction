package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AwesomeGenerator implements Generator {
    public List<String> scan(State dfa, String text) {
        List<String> result = new ArrayList<>();

        while (text.length() > 0) {
            String token = nextWord(dfa, text);
            result.add(token);
            text = text.substring(token.length());
        }
        return result;
    }

    private String nextWord(State dfa, String text) {
        int i = 0;
        String token = "";
        State state = dfa;

        Stack<State> stack = new Stack<>();
        // move forward until it fails
        while (state != null && i < text.length()) {
            token += text.charAt(i);

            if (state.isAccepting()) {
                stack.clear();
            }
            stack.add(state);

            state = state.getNext(text.charAt(i));
            i++;
        }

        // and rollback to the last accepting state
        while ((state == null || !state.isAccepting()) && stack.size() != 0) {
            state = stack.pop();
            token = token.substring(0, token.length() - 1);
            i--;
        }
        return token;
    }
}
