import java.util.Arrays;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 使用插入排序优化
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort4(arr, l ,r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 在数组完全有序时会退化成n方的算法，且递归深度为n
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        // arr[l + 1, j] < v, arr[j + 1, i] >= v
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generatorRandomArray(1000000, 1000000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "QuickSort");
        SortHelper.sortTest(arr2, "MergeSort");

        arr = ArrayGenerator.generatorOrderArray(70000);
        arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "QuickSort");
        SortHelper.sortTest(arr2, "MergeSort");
    }
}
