package LC400_02_String;

/**
 * Created by Gary on 11/12/18.
 */
public class LC12 {
    public String intToRoman(int num) {
        if (num <= 0) return "";//只能表示正整数
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//符号表
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//符号表对应的值
        StringBuilder result = new StringBuilder();
        for (int i = 0; num != 0; i++) { // 从大值往小值减
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbol[i]); // 把减掉的值所对应的符号附加到结果字符串后面
            }
        }
        return result.toString();
    }
}
