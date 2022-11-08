/*
 * 622. 设计循环队列
 */
package MyCircularQueue;

public class MyCircularQueue {
    Integer[] data;
    int front;
    int tail;
    int size;

    public MyCircularQueue(int k) {
        data = new Integer[k];
    }

    public boolean enQueue(int value) {
        if (data.length == size) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return tail == 0? data[data.length - 1]: data[tail - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
