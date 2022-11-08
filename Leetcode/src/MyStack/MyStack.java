/*
 * 225. 用队列实现栈
 */
package MyStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    Deque<Integer> q1;

    public MyStack() {
        q1 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.addLast(x);
    }

    public int pop() {
        for (int i = 0; i < q1.size() - 1; i ++) {
            q1.addLast(q1.remove());
        }
        return q1.remove();
    }

    public int top() {
        int ret = pop();
        q1.addLast(ret);
        return ret;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
