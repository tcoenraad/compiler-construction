package pp.block1.cc.dfa;

import java.util.ArrayList;
import java.util.List;

public class AwesomeGenerator implements Generator {
    public List<String> scan(State dfa, String text) {
        List<String> result = new ArrayList<String>();

        int i = 0;
        while (i < text.length()) {
            State state = dfa;
            String token = "";

            while (i < text.length()) {
                state = state.getNext(text.charAt(i));
                if (state != null) {
                    token += text.charAt(i);
                } else {
                    break;
                }
                i++;
            }
            result.add(token);
        }
        return result;
    }
}
