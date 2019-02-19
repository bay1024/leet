package LC400_01_Array;

/**
 * Created by Gary on 12/9/18.
 */
public class LC245 {
    // time : O (n)
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            // 判断当前单词和word1是否相同，相同的话把index1赋值为当前索引
            if (current.equals(word1)) {
                index1 = i;
            }
            // 判断当前单词和word2是否相同，相同的话把index2赋值为当前索引
            // 但是区别是在赋值之前要判断word1和word2是否相同，若相同需要先index1=index2
            if (current.equals(word2)) {
                if (word1.equals(word2)) {
                    index1 = index2;
                }
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
}
