public class NoWasteLoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;
    public NoWasteLoopQueue(int capacity) {
        data = (E[])new Object[capacity];
    }
    public NoWasteLoopQueue() {
        this(10);
    }
    public int getCapacity() {
        return data.length;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
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
        E[] newData = (E[])new Object[newCapacity];
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
        res.append(String.format("NoWasteLoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i ++) {
            res.append(data[(front + i) % data.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args) {
        NoWasteLoopQueue<Integer> arr = new NoWasteLoopQueue<>();
        for (int i = 0; i < 10; i ++) {
            arr.enqueue(i);
            System.out.println(arr);
            if (i % 3 == 2) {
                arr.dequeue();
            }
        }
    }
}
