package LC400_11_Stack_PQ;

import java.util.Stack;

/**
 * Created by Gary on 2019-01-16.
 */
public class LC84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        // 存储递增高度序列
        Stack<Integer> stack = new Stack<>();
        // 结果
        int result = 0;
        // 需要遍历到最后length处
        for (int i = 0; i <= heights.length; i++) {
            // 如果i==length,此时要让h = 0， 从而对栈中的元素做一次计算
            int h = (i == heights.length ? 0 : heights[i]);
            // 栈不空&&前一个高度> h，符合清算条件
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // 高度为前一个高度，pop出来
                int height = heights[stack.pop()];
                // 宽度起始点，如果栈为空，则是最左端，否则是栈顶的那个index
                int start = stack.isEmpty() ? -1 : stack.peek();
                // 计算面积
                int area = height * (i - start - 1);
                result = Math.max(result, area);
            }
            // 入栈
            stack.push(i);
        }
        return result;
    }
}
