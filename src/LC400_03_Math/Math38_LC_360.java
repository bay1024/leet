package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math38_LC_360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int num1 = quad(nums[i], a, b, c);
            int num2 = quad(nums[j], a, b, c);
            if (a >= 0) {
                if (num1 >= num2) {
                    sorted[index] = num1;
                    i++;
                } else {
                    sorted[index] = num2;
                    j--;
                }
                index--;
            } else {
                if (num1 >= num2) {
                    sorted[index] = num2;
                    j--;
                } else {
                    sorted[index] = num1;
                    i++;
                }
                index++;
            }
        }
        return sorted;
    }

    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
