package LC400_02_String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gary on 11/23/18.
 */
public class LC266 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!set.contains(curr))    set.remove(curr);
            else                        set.add(curr);
        }
        return set.size() == 0 || set.size() == 1;
    }
}
