package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AwesomeGenerator implements Generator {
    private int input;
    private int fence;
    private int n;
    private List<Character> buffer;

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
        input = 0;
        fence = 0;
        buffer = new ArrayList<>();
        State state = dfa;
        String token = "";

        Stack<State> stack = new Stack<>();
        stack.push(null);

        n = text.length();
        for(int i = 0; i < n; i++){
            buffer.add(i, text.charAt(i));
        }

        int i = 0;
        while (state != null && i < n) {
            char c = nextChar();
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
            rollBack();
        }
        return token;
    }

    private void rollBack(){
        if (input != fence){
            input = (input - 1) % (2*n);
        }
    }

    private char nextChar(){
        char c = buffer.get(input);
        input = (input + 1) % (2*n);
        if ((input % n) == 0){
           for (int i = 0; i < n; i++){
               buffer.add(i + n, buffer.get(i));
               fence = (input + n) % (2*n);
           }
        }
        return c;
    }
}
