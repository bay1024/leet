package LC400_11_Stack_PQ;

import java.util.*;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC347 {
    // bucket sort - time:O(n), space:O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) bucket[freq] = new LinkedList<>();
            bucket[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) result.addAll(bucket[i]);
        }

        return result;
    }

    // PriorityQueue- time: O(klogn) space: O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap
                = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        maxHeap.addAll(map.entrySet());
        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result.add(entry.getKey());
        }
        return result;
    }

    // TreeMap- time: O(klogn) space: O(n)
    public List<Integer> topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (freqMap.containsKey(freq)) {
                freqMap.get(freq).add(num);
            } else {
                freqMap.put(freq, new LinkedList<>());
                freqMap.get(freq).add(num);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            result.addAll(entry.getValue());
        }
        return result;
    }
}
