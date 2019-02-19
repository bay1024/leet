package LC400_01_Array.SUB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class LC249 {
    private String shuffle(String word){
        StringBuilder result= new StringBuilder();
        char bar = word.charAt(0);
        for(char ch: word.toCharArray()){
            int offset = (ch-bar) < 0 ? (ch - bar + 26) : (ch - bar);
            result.append((char)(offset + 'a'));
        }
        System.out.println(result.toString());
        return result.toString();
    }
    // 用HashMap来进行各个str的划分，然后关键问题就是找到一个划分的标准了。
    // 1，首先必须等长str，第一个条件；
    // 2，然后各个自己字母之间的差距是一样的；
    // 3，如果遇到了katy这样的情况，a比k小，那么差值就成了负数，那么就需要+26；我想可以通过尝试一个数组来存储这样的信息，但是把数组作为key，显然不合适？若是把sigma加和作为key也同样不合适，abc和acb就是同一个key了，不满足条件。。。
    // 参考了别人的答案，瞬间明白，用一个新的String来代表不就完了么，本质上就是你个那个整型数组的思想啊。
    // g加面的第二道题，只是那里给出了一个明确的定义，给出了shorten这个方法，直接就可以得到一个key了，这里的话需要自己思考出一个key，这往往也是解题的关键。

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = shuffle(str);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"wab", "wcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> result = new LC249().groupStrings(strs);
        System.out.println(result);
    }
}
