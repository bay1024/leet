package LC400_01_Array;

/**
 * Created by Gary on 12/13/18.
 */
public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current <= small)       small = current;// update small if current is smaller
            else if (current <= big)    big = current; // update big only if current is greater than small and smaller than big
            else                        return true; // return true if find a number is bigger than both
        }
        return false;
    }
}
