package LC400_01_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary on 12/9/18.
 */
class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                map.get(word).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexsOfWord1 = map.get(word1);
        List<Integer> indexsOfWord2 = map.get(word2);
        int index1 = 0, index2 = 0;
        int result = Integer.MAX_VALUE;
        while (index1 < indexsOfWord1.size() && index2 < indexsOfWord2.size()) {
            int i = indexsOfWord1.get(index1);
            int j = indexsOfWord2.get(index2);
            result = Math.min(result, Math.abs(i - j));
            if (i < j)  index1++;
            else        index2++;
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
public class LC244 {
}
