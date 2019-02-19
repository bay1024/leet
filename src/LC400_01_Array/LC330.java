package LC400_01_Array;

/**
 * Created by Gary on 12/21/18.
 */
public class LC330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 10};
        System.out.println(new LC330().minPatches(numbers, 20));
    }
}
