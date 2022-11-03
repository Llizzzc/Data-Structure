import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Random r = new Random();
        return selectK(nums, 0, nums.length - 1, nums.length - k, r);
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
}
