
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arr = new ArrayStack<>();
        for (int i = 0; i < 10; i ++) {
            arr.push(i);
            System.out.println(arr);
        }

    }
}
