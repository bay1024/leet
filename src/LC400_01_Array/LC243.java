package LC400_01_Array;

/**
 * Created by Gary on 12/4/18.
 */
public class LC243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int indexOfWord1 = -1, indexOfWord2 = -1;
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (curr.equals(word1)) {
                indexOfWord1 = i;
            } else if (curr.equals(word2)) {
                indexOfWord2 = i;
            }
            if (indexOfWord1 != -1 && indexOfWord2 != -1) {
                result = Math.min(result, Math.abs(indexOfWord1 - indexOfWord2));
            }
        }
        return result;
    }
}
