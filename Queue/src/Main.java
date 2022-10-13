import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opData[] = {10000, 100000};
        for (int opCount : opData) {
            ArrayQueue<Integer> q1 = new ArrayQueue<>();
            double time1 = test(q1, opCount);
            System.out.println("ArrayQueue: " + time1 + "s");

            LoopQueue<Integer> q2 = new LoopQueue<>();
            double time2 = test(q2, opCount);
            System.out.println("LoopQueue: " + time2 + "s");
        }
    }
    private static double test(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i ++) {
            q.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1.0e9;
    }

}
