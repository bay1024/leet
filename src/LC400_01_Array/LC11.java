package LC400_01_Array;

/**
 * Created by Gary on 12/12/18.
 */
public class LC11 {
    public int maxArea(int[] height) {
        int result = 0, temp;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            temp = min * (right - left);
            result = Math.max(result, temp);
            if (height[left] < height[right]) {
                int last = height[left];
                while (left < right && height[left] <= last) left++;
            } else {
                int last = height[right];
                while (left < right && height[right] <= last) right--;
            }
        }
        return result;
    }
}
