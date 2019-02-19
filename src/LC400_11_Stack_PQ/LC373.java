package LC400_11_Stack_PQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC373 {
    // time O(k Log k); space O(k)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});

        while (!pq.isEmpty() && k-- > 0) {
            int[] curr = pq.poll();
            result.add(new int[]{curr[0], curr[1]});
            if (curr[2] == nums2.length - 1) continue;
            pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return result;
    }
}
