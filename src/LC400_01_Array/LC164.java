package LC400_01_Array;

/**
 * Created by Gary on 12/13/18.
 */
public class LC164 {
    public int maximumGap(int[] nums) {
//        [3,6,9,1]
        int n = nums.length;
        if (n < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (min > nums[i]) min = nums[i];
            if (max < nums[i]) max = nums[i];
        }
        int gap = (max - min) / (n - 1);
        if (gap == 0) gap++;
        int len = (max - min) / gap + 1;
        int[] tmax = new int[len];
        int[] tmin = new int[len];

        for (int i = 0; i < n; i++) {
            int index = (nums[i] - min) / gap;
            if (nums[i] > tmax[index]) tmax[index] = nums[i];
            if (tmin[index] == 0 || nums[i] < tmin[index]) tmin[index] = nums[i];
        }
        int myMax = 0;
        for (int i = 0; i < len; i++) {
            if (myMax < tmin[i] - min) myMax = tmin[i] - min;
            if (tmax[i] != 0) min = tmax[i];
        }
        return myMax;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 7, 9};
        System.out.println(new LC164().maximumGap(numbers));
    }
}
