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
            MergeSort.sort(arr);
        } else if (sortName.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        } else if (sortName.equals("MergeSort3")) {
            MergeSort.sort3(arr);
        } else if (sortName.equals("MergeSort4")) {
            MergeSort.sort4(arr);
        } else if (sortName.equals("MergeSortBU")) {
            MergeSort.sortBU(arr);
        } else if (sortName.equals("MergeSortBU2")) {
            MergeSort.sortBU2(arr);
        } else if (sortName.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (sortName.equals("QuickSort2")) {
            QuickSort.sort2(arr);
        } else if (sortName.equals("QuickSort3")) {
            QuickSort.sort3(arr);
        } else if (sortName.equals("QuickSort4")) {
            QuickSort.sort4(arr);
        } else if (sortName.equals("QuickSort5")) {
            QuickSort.sort5(arr);
        }
        long end = System.nanoTime();
        double time = (end - start) / 1.0e9;
        if (!SortHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.printf("%s: %d data cost %.2fs\n", sortName, arr.length, time);
    }
}