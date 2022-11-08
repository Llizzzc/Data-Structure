/*
 * 155. 最小栈
 */
package MinStack;

import java.util.Stack;

public class MinStack {
    Stack<Long> stack;  // 存入差值可能会导致int型溢出
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        }
        stack.push(min - val);  // 存入差值，第一次入栈为0
        if (min > val) {
            // 入栈更小的数则存入正数，否则为负数
            min = val;
        }
    }

    public void pop() {
        if (stack.peek() > 0) {
            min = min + stack.peek();
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() > 0) {
            return (int)min;
        }
        return (int)(min - stack.peek());
    }

    public int getMin() {
        return (int)min;
    }
}
