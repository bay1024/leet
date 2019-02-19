package LC400_11_Stack_PQ;

import java.util.*;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC332 {
    Map<String, PriorityQueue<String>> map;
    List<String> result;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        result = new LinkedList<>();
        for (String[] t : tickets) {
            if (map.get(t[0]) == null) {
                map.put(t[0], new PriorityQueue<>());
            }
            map.get(t[0]).add(t[1]);
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String from) {
        while (map.get(from) != null && !map.get(from).isEmpty()) {
            dfs(map.get(from).poll());
        }
        result.add(0, from);
    }
}
