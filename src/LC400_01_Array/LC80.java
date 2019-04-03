package LC400_01_Array;

/**
 * Created by Gary on 11/24/18.
 */
public class LC80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        // 与上题相似，也用双指针，多一个判断即可
        int left = 1, right = 2;
        while (right < nums.length) {
            // 右指针和左指针处数字相同，且和左指针左边的数字相同，
            if (nums[right] == nums[left] && nums[right] == nums[left - 1]) {
                right++; // 把右指针右移即可
            } else {  // 否则
                left++; // 移动左指针
                nums[left] = nums[right]; // 右指针数字放入左指针处
                right++; // 向右移动右指针
            }
        }
        return left + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
