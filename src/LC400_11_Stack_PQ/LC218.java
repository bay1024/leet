package LC400_11_Stack_PQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC218 {
    class Point implements Comparable {
        int x, y;
        Point(int x, int y) { this.x = x;this.y = y; }
        public int compareTo(Object p) { return ((Point) p).y - this.y; }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings.length == 0 || buildings[0].length == 0) return result;
        PriorityQueue<Point> queue = new PriorityQueue<>(); //max heap ordered by the height of the building
        int[] points = new int[buildings.length * 2];
        for (int i = 0; i < buildings.length; ++i) {
            points[2 * i] = buildings[i][0];
            points[2 * i + 1] = buildings[i][1];
        }
        Arrays.sort(points);// only examine interested points where a building starts or ends
        int index = 0;
        int prevH = 0;
        int prevP = -1;
        for (int p : points) {
            //remove candidates whose x coordinate is smaller than current pos
            while (!queue.isEmpty() && queue.peek().x <= p) queue.poll();
            while (index < buildings.length && p == buildings[index][0]) {
                //encounter a new building; add the height and the end of the building to the queue
                queue.add(new Point(buildings[index][1], buildings[index][2]));
                ++index;
            }
            if (prevP == p) continue; //skip duplicates ending positions
            else            prevP = p;
            if (queue.isEmpty()) {
                result.add(new int[]{p, 0});
                prevH = 0;
            } else {
                int h = queue.peek().y;
                if (prevH != h) { //only care about situations where the max height changes
                    result.add(new int[]{p, h});
                    prevH = h;
                }
            }
        }
        return result;
    }
}
