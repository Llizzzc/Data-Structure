import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size;

    // 传入容量构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 默认容量
    public Array() {
        this(10);
    }

    // 返回元素个数
    public int getSize() {
        return size;
    }

    // 返回容量
    public int getCapacity() {
        return data.length;
    }

    // 判断是否空
    public boolean isEmpty() {
        return size == 0;
    }

    // 末尾添加
    public void addLast(E e) {
        add(e, size);
    }

    // 开头添加
    public void addFirst(E e) {
        add(e, 0);
    }

    // 指定插入
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 && index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    // 修改指定位置
    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    // 查看是否有e
    public Boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找元素并返回索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 查找指定的所有元素
    public int[] findAll(E e) {
        int[] indexArr = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                indexArr[j] = i;
                j++;
            }
        }
        return Arrays.copyOf(indexArr, j);
    }

    // 删除指定元素
    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除首个
    public E deleteFirst() {
        return delete(0);
    }

    // 删除最后
    public E deleteLast() {
        return delete(size - 1);
    }

    // 查找并删除
    public void findDelete(E e) {
        if (find(e) != -1) {
            delete(find(e));
        }
        if (contains(e)) {
            findDelete(e);
        }
    }

    // 扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        LinkedList<Integer> list = new LinkedList<>();
        int[] opData = {100000, 10000000};
        for (int op : opData) {
            double start = System.nanoTime();
            for (int i = 0; i < op; i++) {
                arr.addLast(i);
            }
            double end = System.nanoTime();
            double time = (end - start) / 1.0e9;
            System.out.printf("ArrayList cost %fs\n", time);

            start = System.nanoTime();
            for (int i = 0; i < op; i++) {
                list.addFirst(i);
            }
            end = System.nanoTime();
            time = (end - start) / 1.0e9;
            System.out.printf("LinkedList cost %fs\n", time);
        }

    }
}
