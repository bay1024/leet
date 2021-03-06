package LC400_11_Stack_PQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC225 {
    class MyStack {
        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.offer(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
