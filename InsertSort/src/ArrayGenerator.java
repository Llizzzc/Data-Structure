import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {
    }

    // 顺序数组
    public static Integer[] generatorOrderArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 生成随机数组，范围[0, bound)
    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
