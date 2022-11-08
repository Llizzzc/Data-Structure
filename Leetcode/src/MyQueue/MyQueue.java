/*
 * 232. 用栈实现队列
 */
package MyQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> q1;
    int front;
    public MyQueue() {
        q1 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            front = x;
        }
        q1.addLast(x);
    }

    public int pop() {
        Deque<Integer> q2 = new ArrayDeque<>();
        while (q1.size() > 1) {
            front = q1.peekLast();
            q2.addLast(q1.removeLast());
        }
        int ret = q1.removeLast();
        while (!q2.isEmpty()) {
            q1.addLast(q2.removeLast());
        }
        return ret;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
