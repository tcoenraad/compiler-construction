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
        State state = dfa;
        String token = "";

        Stack<State> stack = new Stack<>();
        stack.push(null);

        int i = 0;
        while (state != null && i < text.length()) {
            char c = text.charAt(i);
            token = token + c;

            if (state.isAccepting()) {
                stack.clear();
            }

            stack.push(state);
            state = state.getNext(c);
            i++;
        }
        while ((state == null || !state.isAccepting()) && stack.size() > 0) {
            state = stack.pop();
            token = text.substring(0, token.length() - 1);
        }
        return token;
    }
}
