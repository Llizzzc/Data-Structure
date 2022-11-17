public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4 ,5 ,6};
        SegmentTree<Integer> st = new SegmentTree<>(arr, (a, b) -> a + b);
        System.out.println(st.query(2, 4));
    }
}