package LC400_01_Array;

/**
 * Created by Gary on 11/28/18.
 */
public class LC134 {
    /** 现象：
     1.假如从位置i开始，i+1, i+2, ..., 一路开过来油箱都没空，说明从i到i+1, i+2...肯定都是正积累。
     2.现在突然发现开往位置j时油箱空了。说明从位置i开始没法走完全程。那么，需要从i+1开始重新尝试吗？
        不用！因为前面已经知道，位置i肯定是正积累，那么如果从位置i+1开始走，就更加没法走完全程了，因为没有位置i的正积累了。
        同理，也不用从i+2, i+3, ... , j开始尝试。可以放心从j+1开始尝试。
     Time:O(n), time: O(1)
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return total < 0 ? -1 : start;
    }
}
