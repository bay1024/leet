package LC400_02_String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 11/11/18.
 */
public class LC271 {
    // Encodes a list of strings to a single LC400_02_String.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single LC400_02_String to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slashIndex = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slashIndex));
            result.add(s.substring(slashIndex + 1, slashIndex + size + 1));
            i = slashIndex + size + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("/a/bc");
        strs.add("c//def");
        LC271 lc271 = new LC271();
        String encode = lc271.encode(strs);
        System.out.println(encode);
        System.out.println(lc271.decode(encode));
    }
}
