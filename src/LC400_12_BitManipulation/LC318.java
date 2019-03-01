package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-23.
 */
public class LC318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int len = words.length;
        // 用来存储编码后的单词
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            // 对每个单词进行编码
            value[i] = enCode(words[i]);
        }
        // 存储结果，最大乘积
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 两层循环，如果两个单词没有重复的字母
                if ((value[i] & value[j]) == 0) {
                    // 计算两个单词的长度乘积
                    int product = words[i].length() * words[j].length();
                    // 更新最大乘积
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        return maxProduct;
    }

    private int enCode(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result |= 1 << (word.charAt(i) - 'a');
        }
        return result;
    }
}
