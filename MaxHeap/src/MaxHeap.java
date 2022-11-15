public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 直接将任意arr整理为最大堆形式，时间复杂度为O(n); 而add n次时间复杂度为O(n*log n);
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获得index的父亲节点索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 获取index的左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 获取index的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 从堆中取出最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.deleteLast();
        siftDown(0);
        return ret;
    }
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 首先获取左右孩子的较大值
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            // 然后与k位置比较
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Find max failed. Empty data now.");
        }
        return data.get(0);
    }

    // 取出最大元素，并替换成e
    public E replace(E e) {
        E ret = findMax();
        data.set(e, 0);
        siftDown(0);
        return ret;
    }
}
