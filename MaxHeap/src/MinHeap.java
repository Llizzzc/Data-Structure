public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(E[] arr) {
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

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.deleteLast();
        siftDown(0);
        return ret;
    }
    private E findMin() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Empty heap now.");
        }
        return data.get(0);
    }
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                data.swap(k, j);
            }
            k = j;
        }
    }

    public E replace(E e) {
        E ret = data.get(0);
        data.set(e, 0);
        siftDown(0);
        return ret;
    }

}
