package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC388 {

    public int lengthLongestPath2(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // dummy length
        int maxLen = 0;  // 存储结果
        String[] splits = input.split("\n"); // 按照回车换行分割字符串
        for (String current : splits) {
            int level = current.lastIndexOf("\t") + 1; // 计算\t的个数
            while (level + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + current.length() - level + 1; // 删除\t 增加/
            stack.push(len);
            // 如果是文件，就更新一下结果
            if (current.contains("."))
                maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    public int lengthLongestPath(String input) {
        String[] splits = input.split("\n");
        int[] stack = new int[splits.length + 1];
        int maxLen = 0;
        for (String current : splits) {
            int level = current.lastIndexOf("\t") + 1;
            int currentLength = stack[level] + current.length() - level + 1;
            stack[level + 1] = currentLength;
            if (current.contains("."))
                maxLen = Math.max(maxLen, currentLength - 1);
        }
        return maxLen;
    }
}
