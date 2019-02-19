package LC400_11_Stack_PQ;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC341 {
    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger current = stack.peek();
                if (current.isInteger()) return true;
                stack.pop();
                List<NestedInteger> temp = current.getList();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    stack.push(temp.get(i));
                }
            }
            return false;
        }
    }
}
