package LC400_02_String;

import java.util.Stack;

/**
 * Created by Gary on 11/11/18.
 */
public class LC316 {
    public String removeDuplicateLetters(String s) {
        //统计每个字符出现的次数
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }

        //每个字符是否使用，由于只保留一个，所以这地方最多需要26个。
        boolean[] visited = new boolean[26];

        //结果集
        Stack<Character> result = new Stack<>();
        for (char c : chars) {
            count[c - 'a']--;
            //结果集里已经有了，不需要再放进来了。
            if (visited[c - 'a'])   continue;

            //优化步骤
            while (!result.isEmpty() && count[result.peek() - 'a'] > 0 && c < result.peek()) {
                //后面有更好的，则删除，设置为没有用过。
                visited[result.peek() - 'a'] = false;
                result.pop();
            }

            //更新状态
            result.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        //正序，先入的先出！
        for (char c : result) sb.append(c);
        return sb.toString();
    }
}
