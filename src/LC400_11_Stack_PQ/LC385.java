package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-16.
 */

public class LC385 {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (start < i) {
                    int num = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedInteger(num));
                }
                start = i + 1;
                if (c == ']') stack.pop();
            }
        }
        return res;
    }
}
