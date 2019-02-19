package LC400_11_Stack_PQ;

import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC313 {
    class Num implements Comparable<Num> {
        int val, idx, p;
        Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }
        @Override
        public int compareTo(Num that) { return this.val - that.val; }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int prime : primes) pq.add(new Num(prime, 1, prime));
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }
        return ugly[n - 1];
    }
}
