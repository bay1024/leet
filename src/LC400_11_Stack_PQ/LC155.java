package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-14.
 */
public class LC155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            // min栈为空或者要放入的元素不大于栈顶，则放入min栈
            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            //若正常栈为空，则直接返回
            if (stack.isEmpty()) return;
            // 若正常站和min栈的栈顶一样，则要把min栈pop一下
            int n1 = stack.peek();
            int n2 = minStack.peek();
            if (n1 == n2) minStack.pop();
            // 再把正常栈pop一下
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
