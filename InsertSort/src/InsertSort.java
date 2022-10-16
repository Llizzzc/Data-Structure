import java.util.Arrays;

public class InsertSort {

    private InsertSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 为arr[i]选择合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    // 小优化
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    // 从后往前
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] dateSize = {10000, 100000};
        for (int n : dateSize) {
            // 查看常常数级优化效果
            Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortHelper.sortTest(arr, "InsertSort");
            SortHelper.sortTest(arr2, "InsertSort2");
            System.out.println();
            // 在数据有序情况下，比较插入和选择排序
            System.out.println("Order Array: ");
            arr = ArrayGenerator.generatorOrderArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortHelper.sortTest(arr, "InsertSort2");
            SortHelper.sortTest(arr2, "SelectSort");
            System.out.println();
        }
    }
}
