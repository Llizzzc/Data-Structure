/*
 * 303. 区域和检索 - 数组不可变
 */
package NumArray;

public class NumArray {
    private SegmentTree<Integer> st;

    private int[] sum;  // sum[i]存储前i个元素之和

//    public NumArray(int[] nums) {
//        if (nums.length > 0) {
//            Integer[] data = new Integer[nums.length];
//            for (int i = 0; i < nums.length; i ++) {
//                data[i] = nums[i];
//            }
//            st = new SegmentTree<Integer>(data, (a, b) -> a + b);
//        }
//    }

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i ++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
