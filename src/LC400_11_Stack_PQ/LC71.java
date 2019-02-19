package LC400_11_Stack_PQ;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "/";
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");

        for (String s : strs) {
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) stack.push(s);
        }

        ArrayList<String> list = new ArrayList<>(stack);

        return "/" + String.join("/", list);
    }
}
