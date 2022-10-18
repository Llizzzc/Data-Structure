import java.util.Random;

public class Main {
    // 比较ArrayStack和LinkedStack的操作性能
    public static void main(String[] args) {
        int[] opData = {10000, 100000};
        for (int opCount : opData) {
            ArrayStack<Integer> arrayStack = new ArrayStack<>();
            double time1 = test(arrayStack, opCount);
            System.out.println("ArrayStack: " + time1 + "s");

            LinkedStack<Integer> linkedStack = new LinkedStack<>();
            double time2 = test(linkedStack, opCount);
            System.out.println("LinkedStack: " + time2 + "s");
        }
    }

    private static double test(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        return (end - start) / 1.0e9;
    }
}
