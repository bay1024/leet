package LC400_01_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gary on 12/9/18.
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) return true;
        }
        return false;
    }
}
