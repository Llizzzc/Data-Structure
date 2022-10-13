public class ArrayDeque<E> implements Deque<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;
    public ArrayDeque(int capacity) {
        data = (E[])new Object[capacity];
    }

    public ArrayDeque() {
        this(10);
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public int getCapacity() {
        return data.length;
    }
    @Override
    public void addTail(E e) {
        if (size == data.length) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
    @Override
    public void addFront(E e) {
        if (size == data.length) {
            resize(getCapacity() * 2);
        }
        front = (front + (data.length - 1)) % data.length;
        data[front] = e;
        size ++;
    }
    @Override
    public E removeTail() {
        if (size == 0) {
            throw new IllegalArgumentException("deque is empty now");
        }
        tail = (tail + (data.length - 1)) % data.length;
        E ret = data[tail];
        data[tail] = null;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 !=0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }
    @Override
    public E removeFront() {
        if (size == 0) {
            throw new IllegalArgumentException("deque is empty now");
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
        if (size == 0) {
            throw new IllegalArgumentException("deque is empty now");
        }
        return data[front];
    }
    public void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size = %d, capacity = %d\n", size, getCapacity()));
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
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0) arr.addTail(i);
            else arr.addFront(i);
            System.out.println(arr);
        }
        System.out.println();
        for(int i = 0; !arr.isEmpty(); i ++){
            if(i % 2 == 0) arr.removeFront();
            else arr.removeTail();
            System.out.println(arr);
        }
    }
}
