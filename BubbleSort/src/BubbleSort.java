public class BubbleSort {

    private BubbleSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        // 进行n-1轮循环
        for (int i = 0; i + 1 < data.length; i ++) {
            // arr[n - i, n)已排序
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    // 优化，如果某一轮没有元素交换，则此时数组已经有序
    public static <E extends Comparable<E>> void sort2(E[] data) {
        // 进行n-1轮循环
        for (int i = 0; i + 1 < data.length; i ++) {
            boolean isSwapped = false;
            // arr[n - i, n)已排序
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    // 再优化，记录最后一次发生交换的索引lastSwappedIndex，则[lastSwappedIndex, n)已经有序
    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = 0; i + 1 < data.length; ) {
            int lastSwappedIndex = 0;
            // arr[n - i, n)已排序
            for (int j = 0; j < data.length - i - 1; j ++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = data.length - lastSwappedIndex;
        }
    }

    // 从后向前冒泡
    public static <E extends Comparable<E>> void sort4(E[] data) {
        for (int i = 0; i + 1 < data.length; ) {
            int lastSwappedIndex = data.length - 1;
            // arr[0, i)已排序
            for (int j = data.length - 1; j > i; j --) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j, j - 1);
                    lastSwappedIndex = j - 1;
                }
            }
            i = lastSwappedIndex + 1;
        }
    }

    private static <E> void swap(E[] data, int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
