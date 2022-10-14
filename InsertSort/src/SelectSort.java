public class SelectSort {
    private SelectSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 每次循环前[0, i)已排序，[i, n)未排序
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;   // 选择[i...n)中的最小值索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //  从后向前排序
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;    // 选择[0, i]中的最大值索引
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        Student[] students = {new Student("bob", 92),
//                new Student("alice", 85), new Student("dell", 77)};
//        sort(students);
//        for (Student student : students) {
//            System.out.println(student);
//        }

        int[] dateSize = {10000, 100000};
        for (int n : dateSize) {
            Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
            SortHelper.sortTest(arr, "SelectSort");
        }
    }
}


