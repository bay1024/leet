package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        String str = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (c == '[') {
                stringStack.push(str);
                str = "";
                i++;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for (int j = 0; j < repeat; j++) {
                    sb.append(str);
                }
                str = sb.toString();
                i++;
            } else {
                str += c;
                i++;
            }
        }
        return str;
    }
}
