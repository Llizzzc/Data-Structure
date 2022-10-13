public class Array<E> {
    private E[] data;
    private int size;
    // 传入容量构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
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
    // 判读是否空
    public boolean isEmpty() {
        return size == 0;
    }
    // 末尾添加
    public void addList(E e) {
        add(e, size);
    }
    // 开头添加
    public void addFirst(E e) {
        add(e, 0);
    }
    // 指定插入
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("require index >= 0 && index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }
    // 获取元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }
    // 修改指定位置
    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
    }
    // 查看是否有e
    public Boolean contains(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    // 查找并返回索引
    public int find(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    // 删除指定元素
    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }
        size --;
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
    }
    // 扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


}
