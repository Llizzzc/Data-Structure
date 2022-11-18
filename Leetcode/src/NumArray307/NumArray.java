package NumArray307;

public class NumArray {

    private SegmentTree<Integer> st;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i ++) {
                data[i] = nums[i];
            }
            st = new SegmentTree<Integer>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {
        st.set(index, val);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}
