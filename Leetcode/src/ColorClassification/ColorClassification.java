/*
 * 75. 颜色分类
 */
package ColorClassification;

public class ColorClassification {

    public void sortColors(int[] nums) {

        // nums[0, zero] == 0, nums[zero + 1, i] == 1, nums[two, n - 1] == 2
        int zero = -1, i = 0, two = nums.length;
        while (i < two) {
            if (nums[i] == 0) {
                zero ++;
                swap(nums, i, zero);
                i ++;
            } else if (nums[i] == 2) {
                two --;
                swap(nums, i, two);
            } else {
                i ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
