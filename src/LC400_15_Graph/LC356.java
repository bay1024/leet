package LC400_15_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Gary on 2019-01-31.
 */
public class LC356 {
    public boolean isReflected(int[][] points) {
        if (points.length < 2) return true;

        Map<Integer, Set<Double>> presentMap = new HashMap<>();
        int min_x = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;

        for (int[] point : points) {
            min_x = Math.min(point[0], min_x);
            max_x = Math.max(point[0], max_x);
        }

        double x_mid = (double) (min_x + max_x) / 2;

        for (int point[] : points) {
            if (presentMap.get(point[0]) != null)
                presentMap.get(point[0]).add((double) point[1]);
            else {
                Set<Double> set = new HashSet<>();
                set.add((double) point[1]);
                presentMap.put(point[0], set);
            }
        }

        for (int point[] : points) {
            int x_need = (int) (x_mid - (point[0] - x_mid));
            int y_need = point[1];
            if (presentMap.get(x_need) == null) return false;
            if (!presentMap.get(x_need).contains((double) y_need)) return false;
        }

        return true;
    }
}
