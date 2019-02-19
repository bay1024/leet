package LC400_10_BFS_DFS;

import java.util.*;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> candidatePool = new HashSet<>(wordList);
        if (candidatePool.contains(beginWord)) candidatePool.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> wordLevel = new HashMap<>();
        wordLevel.put(beginWord, 1);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int level = wordLevel.get(current);
            for (int i = 0; i < current.length(); i++) {
                char[] chars = current.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String temp = new String(chars);
                    if (candidatePool.contains(temp)) {
                        if (temp.equals(endWord)) return level + 1;
                        wordLevel.put(temp, level + 1);
                        queue.offer(temp);
                        candidatePool.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}
