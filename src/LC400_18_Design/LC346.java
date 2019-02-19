package LC400_18_Design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2019-01-17.
 */
class MovingAverage {
    private Queue<Integer> q;
    private int size;
    private double sum;
    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0.0d;
    }
    public double next(int val) {
        if (this.size == q.size()) {
            sum -= q.poll();
        }
        sum += val;
        q.offer(val);
        return sum / this.q.size();
    }
}

public class LC346 {

}
