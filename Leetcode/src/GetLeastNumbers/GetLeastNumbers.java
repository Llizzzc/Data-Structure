/*
 * 剑指 Offer 40. 最小的k个数
 */
package GetLeastNumbers;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class GetLeastNumbers {

    // 快速排序思想
    public int[] getLeastNumbers(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        Random r = new Random();
        selectK(nums, 0, nums.length - 1, k - 1, r);
        return Arrays.copyOf(nums, k);
    }

    private int selectK(int[] nums, int l, int r, int k, Random rdm) {
        int p = partition(nums, l, r, rdm);
        if (k == p) return nums[p];
        if (k < p) return selectK(nums, l, p - 1, k, rdm);
        return selectK(nums, p + 1, r, k, rdm);
    }

    private int partition(int[] nums, int l, int r, Random rdm) {
        int p = l + rdm.nextInt(r - l + 1);
        swap(nums, l, p);
        // arr[l + 1, i - 1] <= v, arr[j + 1, r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i ++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j --;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i ++;
            j --;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // 优先队列思想，java自带的优先队列为最小堆实现，这里要换成自己实现的最大堆优先队列
    public int[] getLeastNumbers2(int[] nums, int k) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for (int i = 0; i < k; i ++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i ++) {
            if (!pq.isEmpty() && nums[i] < pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
