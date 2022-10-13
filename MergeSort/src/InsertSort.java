public class InsertSort {
    private InsertSort(){}

//    public static <E extends Comparable<E>> void sort(E[] arr) {
//        for (int i = 0; i < arr.length; i ++) {
//            // 为arr[i]选择合适的位置
//            for (int j = i; j - 1 >= 0; j --) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j,j - 1);
//                } else {
//                    break;
//                }
//            }
//        }
//    }

     // 小优化
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j --) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
    public static <E extends Comparable<E>> void sort3(E[] arr, int l, int r) {
        for (int i = l; i <= r; i ++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

//    public static <E extends Comparable<E>> void sort2(E[] arr) {
//        for (int i = arr.length; i > 0; i --) {
//            E t = arr[i - 1];
//            int j;
//            for (j = i - 1; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j ++) {
//                arr[j] = arr[j + 1];
//            }
//            arr[j] = t;
//        }
//    }

//    public static <E> void swap(E[] arr, int i, int j) {
//        E t = arr[i];
//        arr[i] = arr[j];
//        arr[j] = t;
//    }
}
