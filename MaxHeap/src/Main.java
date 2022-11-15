public class Main {

    private static double testHeap(Integer[] arr, boolean isHeap) {
        long start = System.nanoTime();
        MinHeap<Integer> heap;
        if (isHeap) {
            heap = new MinHeap<>(arr);
        } else {
            heap =  new MinHeap<>();
            for (Integer num : arr) {
                heap.add(num);
            }
        }

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            temp[i] = heap.extractMin();
        }

        for (int i = 0, j = 1; j < arr.length; i ++, j ++) {
            if (temp[i] > temp[j]) {
                throw new IllegalArgumentException("Error.");
            }
        }

        System.out.println("Test MinHeap completed.");
        long end = System.nanoTime();
        return (end - start) / 1.0e9;
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generatorRandomArray(1000000, 1000000);
        double time1 = testHeap(arr, true);
        System.out.printf("cost %fs with heap.\n", time1);
        System.out.println();
        double time2 = testHeap(arr, false);
        System.out.printf("cost %fs without heap.\n", time2);
    }
}
