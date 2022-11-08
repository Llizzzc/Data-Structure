/*
 * 704. 二分查找
 */
package BinarySearch;

public class BinarySearch {

    private BinarySearch() {
    }

    // 递归实现
    public int searchR(int[] nums, int target) {
        return searchR(nums, 0, nums.length - 1, target);
    }
    private int searchR(int[] nums, int l, int r, int target) {
        if (l > r) return -1;

        int mid = l + (r - l) / 2;
        if (nums[mid] == 0) {
            return mid;
        }
        if (nums[mid] < target) {
            return searchR(nums, mid + 1, r, target);
        }
        return searchR(nums, l, mid - 1, target);
    }

    // 非递归实现
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 在data[l, r]中查找target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}