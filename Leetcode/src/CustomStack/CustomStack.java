/*
 * 1381. 设计一个支持增量操作的栈
 */
package CustomStack;

import java.util.Vector;

public class CustomStack {
    Vector<Integer> arr;
    public CustomStack(int maxSize) {
        arr = new Vector<>(maxSize);
    }

    public void push(int x) {
        if (arr.size() < arr.capacity()) {
            arr.add(arr.size(), x);
        }
    }
    public int pop() {
        if (!arr.isEmpty()) {
            return arr.remove(arr.size() - 1);
        }
        return -1;
    }

    public void increment(int k, int val) {
        k = Math.min(k, arr.size());
        for (int i = 0; i < k; i ++) {
            arr.set(i, arr.get(i) + val);
        }
    }
}
