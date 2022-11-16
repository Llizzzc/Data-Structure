public class SortHelper {
    private SortHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        // 相邻元素是否有序
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(E[] arr, String sortName) {
        long start = System.nanoTime();
        if (sortName.equals("MergeSort")) {
            MergeSort.sort4(arr);
        } else if (sortName.equals("QuickSort")) {
            QuickSort.sort6(arr);
        } else if (sortName.equals("BubbleSort")) {
            BubbleSort.sort3(arr);
        } else if (sortName.equals("ShellSort")) {
            ShellSort.sort2(arr);
        } else if (sortName.equals("SelectSort")) {
            SelectSort.sort(arr);
        } else if (sortName.equals("InsertSort")) {
            InsertSort.sort2(arr);
        } else if (sortName.equals("HeapSort")) {
            HeapSort.sort2(arr);
        } else if (sortName.equals("ShellSort2")) {
            ShellSort.sort3(arr);
        }
        long end = System.nanoTime();
        double time = (end - start) / 1.0e9;
        if (!SortHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.printf("%s: %d data cost %fs\n", sortName, arr.length, time);
    }
}