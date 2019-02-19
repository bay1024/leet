package LC400_01_Array;

import java.util.HashSet;

/**
 * Created by Gary on 12/13/18.
 */
public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        // 用HashSet过滤掉重复元素，作为map来存放过滤过的数组
        for (int v : nums) set.add(v);
        // 遍历数组，对于每个元素向下向上在set中寻找连续整数，同时更新set
        for (int i = 0; i < nums.length; i++) {
            if (set.size() == 0) break;  // set空了即可终止循环
            // 从当前元素向下找连续的数
            int down = nums[i] - 1;
            while (set.contains(down)) {
                // 若在set中找到小的连续整数，则删除掉，并把down更新为下一个小的连续整数
                set.remove(down);
                down--;
            }
            // 此时，向下寻找结束，同理，开始向上寻找
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            // 向上寻找结束.更新结果
            result = Math.max(result, up - down - 1);
        }
        return result;
    }
}
