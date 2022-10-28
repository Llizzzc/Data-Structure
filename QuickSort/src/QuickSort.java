import java.util.Arrays;
import java.util.Random;

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
        sort2(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort4(arr, l ,r);
            return;
        }
        int p = partition(arr, l, r);
        sort2(arr, l, p - 1);
        sort2(arr, p + 1, r);
    }

    // 针对数组有序情况下性能退化的改进, 添加随机化
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        sort3(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        sort3(arr, l, p - 1);
        sort3(arr, p + 1, r);
    }

    // 只使用一个Random对象
    public static <E extends Comparable<E>> void sort4(E[] arr) {
        Random p = new Random();
        sort4(arr, 0, arr.length - 1, p);
    }
    private static <E extends Comparable<E>> void sort4(E[] arr, int l, int r, Random rdm) {
        if (l >= r) {
            return;
        }
        int p = partition3(arr, l, r, rdm.nextInt(r - l + 1));
        sort4(arr, l, p - 1, rdm);
        sort4(arr, p + 1, r, rdm);
    }

    // 双路快速排序
    public static <E extends Comparable<E>> void sort5(E[] arr) {
        Random p = new Random();
        sort5(arr, 0, arr.length - 1, p);
    }
    private static <E extends Comparable<E>> void sort5(E[] arr, int l, int r, Random rdm) {
        if (l >= r) {
            return;
        }
        int p = partition4(arr, l, r, rdm.nextInt(r - l + 1));
        sort5(arr, l, p - 1, rdm);
        sort5(arr, p + 1, r, rdm);
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

    // 针对数组有序情况下性能退化的改进，添加随机化
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {

        int p = l + (new Random()).nextInt(r - l + 1);
        swap(arr, l, p);
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

    // 只使用一个Random对象
    private static <E extends Comparable<E>> int partition3(E[] arr, int l, int r, int rdm) {

        int p = l + rdm;
        swap(arr, l, p);
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

    // 双路快速排序
    private static <E extends Comparable<E>> int partition4(E[] arr, int l, int r, int rdm) {

        int p = l + rdm;
        swap(arr, l, p);
        // arr[l + 1, i - 1] <= v, arr[j + 1, r] >=v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i ++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j --;
            }
            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
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
        System.out.println("Random Array:");
        Integer[] arr = ArrayGenerator.generatorRandomArray(1000000, 1000000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "QuickSort4");
        SortHelper.sortTest(arr2, "QuickSort5");
        System.out.println();

        System.out.println("Order Array:");
        arr = ArrayGenerator.generatorOrderArray(1000000);
        arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "QuickSort4");
        SortHelper.sortTest(arr2, "QuickSort5");
        System.out.println();

        System.out.println("Special Array:");
        arr = ArrayGenerator.generatorRandomArray(25000, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        SortHelper.sortTest(arr, "QuickSort4");
        SortHelper.sortTest(arr2, "QuickSort5");
        System.out.println();
    }
}
