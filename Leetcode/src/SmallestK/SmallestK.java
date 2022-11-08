/*
 * 面试题 17.14. 最小K个数
 */
package SmallestK;

import java.util.Arrays;
import java.util.Random;

public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Random r = new Random();
        selectK(arr, 0, arr.length - 1, k - 1, r);
        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rdm) {
        int p = partition(arr, l, r, rdm);
        if (k == p) return arr[p];
        if (k < p) return selectK(arr, l, p - 1, k, rdm);
        return selectK(arr, p + 1, r, k, rdm);
    }

    private int partition(int[] arr, int l, int r, Random rdm) {
        int p = l + rdm.nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[l + 1, i - 1] <= v, arr[j + 1, r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i ++;
            }
            while (j >= i && arr[j] > arr[l]) {
                j --;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
