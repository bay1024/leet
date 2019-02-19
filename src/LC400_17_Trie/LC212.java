package LC400_17_Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gary on 2019-01-22.
 */

public class LC212 {
    Set<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, "", trie);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, String s, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j]) return;
        s += board[i][j];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) result.add(s);
        visited[i][j] = true;
        dfs(board, visited, i - 1, j, s, trie);
        dfs(board, visited, i + 1, j, s, trie);
        dfs(board, visited, i, j - 1, s, trie);
        dfs(board, visited, i, j + 1, s, trie);
        visited[i][j] = false;
    }
}
