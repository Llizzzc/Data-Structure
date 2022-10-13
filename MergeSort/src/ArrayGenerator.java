import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator(){}

    // 生成随机数组，范围[0, bound)
    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i ++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
