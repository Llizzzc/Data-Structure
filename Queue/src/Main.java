import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] opData = {10000, 100000};
        // 数组队列和循环队列出入队时间消耗的比较
        for (int opCount : opData) {
            ArrayQueue<Integer> q1 = new ArrayQueue<>();
            double time1 = test(q1, opCount);
            System.out.println("ArrayQueue: " + time1 + "s");

            LoopQueue<Integer> q2 = new LoopQueue<>();
            double time2 = test(q2, opCount);
            System.out.println("LoopQueue: " + time2 + "s");

            LinkedQueue<Integer> q3 = new LinkedQueue<>();
            double time3 = test(q3, opCount);
            System.out.println("LinkedQueue: " + time3 + "s");
        }
    }

    private static double test(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1.0e9;
    }

}
