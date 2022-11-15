/*
 * 215. 数组中的第K个最大元素
 */
package FindKthLargest;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Random r = new Random();
        return selectK(nums, nums.length - k, r);
    }

    // 递归实现
    private int selectKR(int[] nums, int l, int r, int k, Random rdm) {
        int p = partition(nums, l, r, rdm);
        if (k == p) return nums[p];
        if (k < p) return selectKR(nums, l, p - 1, k, rdm);
        return selectKR(nums, p + 1, r, k, rdm);
    }

    // 非递归实现
    private int selectK(int[] nums, int k, Random rdm) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int p = partition(nums, l, r, rdm);
            if (p == k) return nums[p];
            if (k < p) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        throw new IllegalArgumentException("No Solution.");
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

    // 使用优先队列
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i ++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i ++) {
            if (!pq.isEmpty() && nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.remove();
    }
}
