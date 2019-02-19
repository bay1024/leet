package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC232 {
    class MyQueue {
        Stack<Integer> stack, temp;

        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int x) {
            while (!stack.isEmpty()) temp.push(stack.pop());
            temp.push(x);
            while (!temp.isEmpty()) stack.push(temp.pop());
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
