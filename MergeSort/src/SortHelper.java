public class SortHelper {

    private SortHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i ++) {
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
        }
        if (sortName.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        }
        if (sortName.equals("MergeSort3")) {
            MergeSort.sort3(arr);
        }
        if (sortName.equals("MergeSort4")) {
            MergeSort.sort4(arr);
        }
        if (sortName.equals("MergeSortBU")) {
            MergeSort.sortBU(arr);
        }
        long end  = System.nanoTime();
        double time = (end - start) / 1.0e9;
        if (!SortHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.printf("sort: %s, n: %d, time: %f\n", sortName, arr.length, time);
    }
}
