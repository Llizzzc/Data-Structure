public class BinarySearch {

    private BinarySearch() {
    }

    // 递归实现
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }
    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }
        return searchR(data, l, mid - 1, target);
    }

    // 非递归实现
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;
        // 在data[l, r]中查找target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) return mid;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 使用 >=target的最小值索引的思路实现
    public static <E extends Comparable<E>> int search2(E[] data, E target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l < data.length && data[l].compareTo(target) == 0) {
            return l;
        }
        return -1;
    }

    // >target 的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;

        // 在data[l, r]中寻找解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // >target, 返回最小值索引
    // ==target, 返回最大索引
    public static <E extends Comparable<E>> int upperCeil(E[] data, E target) {
        int u  = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    // >target, 返回最小值索引
    // ==target, 返回最小索引
    public static <E extends Comparable<E>> int lowerCeil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            u --;
            while (u >= 0 && data[u].compareTo(target) == 0) {
                u --;
            }
            return u + 1;
        }
        return u;
    }

    // <target 的最大值索引
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1 ,r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // <target, 返回最大值索引
    // ==target, 返回最小索引
    public static <E extends Comparable<E>> int lowerFloor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 <= data.length - 1 && data[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    // <target, 返回最大值索引
    // ==target, 返回最大索引
    public static <E extends Comparable<E>> int upperFloor(E[] data, E target) {
        int l = lower(data, target);
        if (l + 1 <= data.length - 1 && data[l + 1].compareTo(target) == 0) {
            l ++;
            while (l <= data.length - 1 && data[l].compareTo(target) == 0) {
                l ++;
            }
            return l - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i ++) {
            System.out.println(search2(arr, i));
        }
    }
}