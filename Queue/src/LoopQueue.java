public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;
    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
    }
    public LoopQueue() {
        this(10);
    }
    public int getCapacity() {
        return data.length - 1;
    }
    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty now");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 !=0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty now");
        }
        return data[front];
    }
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LoopQueue<Integer> arr = new LoopQueue<>();
        for (int i = 0; i < 10; i ++) {
            arr.enqueue(i);
            System.out.println(arr);
            if (i % 3 == 2) {
                arr.dequeue();
            }
        }
    }
}
