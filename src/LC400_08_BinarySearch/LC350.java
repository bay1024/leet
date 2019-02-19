package LC400_08_BinarySearch;

import java.util.*;

/**
 * Created by Gary on 2019-02-06.
 */
public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        return solution1(nums1, nums2);
        //return solution2(nums1, nums2);
    }

    // 两个数组排好序，左右指针法
    public int[] solution1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] result = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }


    // 遍历两遍
    public int[] solution2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> intersect = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0) {
                    intersect.add(i);
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        int[] result = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            result[i] = intersect.get(i);
        }
        return result;
    }
}
