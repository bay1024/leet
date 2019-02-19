package LC400_11_Stack_PQ;

import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC215 {
    /**time:O(n) space:O(1)
     * 方法1--用快速排序法：拿到一个元素，比它大的放到它的左边，比它小的放到右边，
     * 		那么此时这个元素的位置就是第x大的位置，比较x和k
     * 		若k大，就向右找；若k小，就向左找；若相等，就返回该元素
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)	return 0;
        int left = 0;
        int right = nums.length - 1;
        while(true){
            int pos = partitioin(nums, left, right);
            if(pos + 1 == k)		return nums[pos];
            else if(pos + 1 > k)	right = pos - 1;
            else					left = pos + 1;
        }
    }
    /**
     * 快排序
     */
    private int partitioin(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while(l <= r){
            if(nums[l] < pivot && pivot < nums[r]) swap(nums, l++, r--);
            if(nums[l] >= pivot)	l++;
            if(nums[r] <= pivot)	r--;
        }
        swap(nums, left, r);
        return r;
    }
    /**
     * 交换
     */
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 方法2--优先级队列
     * time: O(nlogk)  spack: O(k)
     */
    public int findKthLargest2(int[] nums, int k) {
        if(nums == null || nums.length == 0)	return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size() > k)	minHeap.poll();
        }
        return minHeap.poll();
    }
}
