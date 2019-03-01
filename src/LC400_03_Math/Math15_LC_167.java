package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math15_LC_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (numbers[left] + numbers[right] < target) {
                // 判断左指针移动到中间还是移动一下
                if (numbers[mid] + numbers[right] < target) left = mid;
                else left++;
            } else if (numbers[left] + numbers[right] > target) {
                // 判断右指针移动到中间还是移动一下
                if (numbers[left] + numbers[mid] > target) right = mid;
                else right--;
            } else
                break;
        }
        result[0] = left + 1;
        result[1] = right + 1;
        return result;
    }
}
