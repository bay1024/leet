package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        int localMax = Integer.MIN_VALUE, globalMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (localMax <= 0) {    // localMax非正数，说明这时候不能累加，因为累加后只会变小
                localMax = num; // 需要置为当前元素值
            } else {                // localMax是正数，说明此时要累加，累加后才能让当前序列和更大
                localMax += num;
            }
            globalMax = Math.max(globalMax, localMax); // 更新globalMax
        }
        return globalMax;
    }
}
