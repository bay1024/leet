package LC400_15_Graph;

/**
 * Created by Gary on 2019-01-31.
 */
public class LC335 {
    // 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
    // 2. Fifth line meets first line and works for the lines after
    // 3. Sixth line crosses first line and works for the lines after
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            int l = x.length;
            if (l <= 3) return false;

            for (int i = 3; i < l; i++) {
                //Fourth line crosses first line and onward
                if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
                // Fifth line meets first line and onward
                if (i >= 4) {
                    if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                        return true;
                }
                // Sixth line crosses first line and onward
                if (i >= 5) {
                    if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4]
                            && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                        return true;
                }
            }
            return false;
        }
    }
}
