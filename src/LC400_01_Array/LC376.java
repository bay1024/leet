package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        LC376 solution = new LC376();
        System.out.println(solution.wiggleMaxLength(numbers));
    }
}
