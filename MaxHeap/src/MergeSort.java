import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 使用减法，避免产生溢出
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 数据有序下的优化
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        // 两个区间之间无序才执行merge
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 使用插入排序优化
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        sort3(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort4(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        sort3(arr, l, mid);
        sort3(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 优化临时数组
    public static <E extends Comparable<E>> void sort4(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort4(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort4(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort4(arr, l, mid, temp);
        sort4(arr, mid + 1, r, temp);
        merge2(arr, l, mid, r, temp);
    }

    // 自底向上的归并
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // 合并的区间长度，每次翻倍
        // 每次合并[i, i + sz - 1]和[i + sz, i + sz + sz - 1]
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge2(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    // 使用插入排序优化自底向上的归并
    public static <E extends Comparable<E>> void sortBU2(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // 对arr[i, i + 15]的所有区间使用插入排序
        for (int i = 0; i < n; i += 16) {
            InsertSort.sort4(arr, i, Math.min(i + 15, n - 1));
        }
        // 合并的区间长度，每次翻倍
        // 每次合并[i, i + sz - 1]和[i + sz, i + sz + sz - 1]
        for (int sz = 16; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge2(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    // 合并两个有序区间arr[l, mid]和arr[mid + 1, r];
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 复制一份arr
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            // temp与arr之间存在一个下标偏移
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    // 只使用公共临时数组
    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        // 每轮循环为arr[k]赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
