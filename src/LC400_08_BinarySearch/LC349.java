package LC400_08_BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Gary on 2019-02-05.
 */
public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        return solution1(nums1, nums2);
        //return solution2(nums1, nums2);
        //return solution3(nums1, nums2);
    }

    // 两个数组排好序，左右指针法
    public int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int k = 0;
        while (it.hasNext()) {
            result[k++] = it.next();
        }
        return result;
    }

    // 二分查找法
    public int[] solution2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return true;
            if (nums[mid] > target) right = mid;
            else left = mid;
        }
        return nums[left] == target || nums[right] == target;
    }

    // 遍历两遍
    public int[] solution3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);

        Set<Integer> intersect = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) intersect.add(i);
        }
        int[] result = new int[intersect.size()];
        Iterator<Integer> iterator = intersect.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        return result;
    }
}