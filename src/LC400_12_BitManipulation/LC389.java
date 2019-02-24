package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-23.
 */
public class LC389 {
    public char findTheDifference(String s, String t) {
        // 字符串t比s多一个字符
        int length = s.length();
        // charCode 初始化为最后t最后一个字符
        int charCode = t.charAt(length);
        // 遍历，对charCode 进行更新
        for (int i = 0; i < length; ++i) {
            charCode -= (int)s.charAt(i);
            charCode += (int)t.charAt(i);
        }
        return (char)charCode;
    }
}
