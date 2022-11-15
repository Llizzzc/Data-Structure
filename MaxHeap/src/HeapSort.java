import java.util.Arrays;

public class HeapSort {

    private HeapSort() {}

    // 需要额外的堆空间
    public static <E extends Comparable<E>> void sort(E[] data) {

        MaxHeap<E> heap = new MaxHeap<>();
        for (E datum : data) {
            heap.add(datum);
        }
        for (int i  = data.length - 1; i >= 0; i --) {
            data[i] = heap.extractMax();
        }

    }

    // 原地排序
    public static <E extends Comparable<E>> void sort2(E[] data) {

        if (data.length <= 1) {
            return;
        }
        // 从最后一个非叶子节点开始，整理成最大堆
        for (int i = ((data.length - 1 - 1) / 2); i >= 0; i --) {
            siftDown(data, i, data.length);
        }
        // 从最后一个位置开始，每次与第一个元素交换，再进行siftDown操作
        for (int i = data.length - 1; i >= 0; i --) {
            swap(data, i, 0);
            siftDown(data, 0, i);
        }
    }
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            // 首先获取左右孩子的较大值
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                j = 2 * k + 2;
            }
            // 然后与k位置比较
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }
    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generatorRandomArray(1000000, 1000000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "MergeSort4");
        SortHelper.sortTest(arr2, "QuickSort5");
        SortHelper.sortTest(arr3, "QuickSort6");
        SortHelper.sortTest(arr4, "HeapSort");
        SortHelper.sortTest(arr5, "HeapSort2");
    }
}
