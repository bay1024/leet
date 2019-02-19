package LC400_01_Array;

import java.util.Arrays;

/**
 * Created by Gary on 12/2/18.
 * 根据维基百科对h指数的定义：
 * “一名科学家的h指数是指其发表的N篇论文中，有h篇论文分别被引用了至少h次，其余N-h篇的引用次数均不超过h次”。
 例如，给定引用次数数组 = [3, 0, 6, 1, 5]，这意味着研究人员总共有5篇论文，每篇分别获得了3, 0, 6, 1, 5次引用。
 由于研究人员有3篇论文分别至少获得了3次引用，且其余两篇的引用次数不超过3次，因而其h指数是3。
 注意：如果存在多个可能的h值，取最大值作为h指数。
 */
public class LC274 {

    public int hIndex(int[] citations) {
        return solution2(citations);
    }

    // time: O(n log n) space: O(1)
    public int solution1(int[] citations) {
        Arrays.sort(citations);
        //[3,0,6,1,5]
        //[0,1,3,5,6]
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

    // time: O(n), space : O(n)
    public int solution2(int[] citations) {
        int[] helper = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            int k = citations[i] <= citations.length ? citations[i] : citations.length;
            helper[k] += 1;
        }
        int sum = 0;
        for (int i = citations.length; i > 0; i--) {
            sum += helper[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
