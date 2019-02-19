package LC400_01_Array;

/**
 * Created by Gary on 12/13/18.
 */
public class LC42 {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int result = 0, left = 0, right = height.length - 1;
        // 确定左右边界，形成一个能够蓄水的凹槽
        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;
        while (left < right) {
            int leftHeight = height[left], rightHeight = height[right];
            if (leftHeight <= rightHeight) {
                while (left < right && leftHeight >= height[++left]) {
                    result += leftHeight - height[left];
                }
            } else {
                while (left < right && rightHeight >= height[--right]) {
                    result += rightHeight - height[right];
                }
            }
        }
        return result;
    }
}
