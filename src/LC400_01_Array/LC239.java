package LC400_01_Array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Gary on 2018-12-24.
 */
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*  用双向队列可以在O(N)时间内解决。
            当遇到新数时，将新数和双向队列的末尾比较，若末尾比新数小，则把末尾扔掉，直到该队列的末尾比新数大或者队列为空。
            这样可以保证队列中元素从头到尾降序排列，由于队列里只有窗口内的数，所以其实就是窗口内第一大，第二大，第三大。。。的数。
            保持队列里只有窗口内数的方法和上一个解法一样，也是每来一个新的，把窗口最左边的扔掉，然后加入新的。
            然而在加新数时，已经把很多没用的扔掉了，这样，队列头部的数并不一定是窗口最左边的数。
            为什么时间复杂度是O(n)?因为每个数只可能被操作最多两次，一次是加入队列的时候，一次是因为有别的更大的数在后面，所以被扔掉，
            或者因为出了窗口而被扔掉
         */
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> dequeue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //每当新数进来的时候，若队列头部的数的下标是窗口最左边的数的下标，则扔掉
            if (!dequeue.isEmpty() && dequeue.peekFirst() == i - k) dequeue.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i])
                dequeue.removeLast();
            // 加入新数
            dequeue.offerLast(i);
            //队列头部就是该窗口内第一大的
            if ((i + 1) >= k) result[i - k + 1] = nums[dequeue.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        LC239 solution = new LC239();
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
