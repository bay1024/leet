package LC400_17_Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary on 2019-01-22.
 */

class WordDictionary {
    Map<Integer, List<String>> dictionary;

    public WordDictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addWord(String word) {
        int index = word.length();
        if (!dictionary.containsKey(index)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            dictionary.put(index, list);
        } else {
            dictionary.get(index).add(word);
        }
    }

    public boolean search(String word) {
        int index = word.length();
        if (!dictionary.containsKey(index)) {
            return false;
        }

        List<String> list = dictionary.get(index);
        for (String s : list) {
            if (isSame(s, word)) return true;
        }
        return false;
    }

    private boolean isSame(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

public class LC211 {


    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String item = "";
    }

    class WordDictionary {
        private TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }

        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) return !node.item.equals("");
            if (chs[k] != '.') {
                return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
            } else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        if (match(chs, k + 1, node.children[i])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }


}
