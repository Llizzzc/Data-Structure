import java.util.Random;

public class Main {

    private static double ufTest(UF uf, int m) {

        long start = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < m; i ++) {
            int p = r.nextInt(uf.getSize());
            int q = r.nextInt(uf.getSize());
            uf.unionElements(p, q);
        }

        for (int i = 0; i < m; i++) {
            int p = r.nextInt(uf.getSize());
            int q = r.nextInt(uf.getSize());
            uf.isConnected(p, q);
        }

        long end = System.nanoTime();
        return (end - start) / 1.0e9;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind1 uf1 = new UnionFind1(size);
        UnionFind2 uf2 = new UnionFind2(size);
        UnionFind3 uf3 = new UnionFind3(size);
        UnionFind4 uf4 = new UnionFind4(size);
        UnionFind5 uf5 = new UnionFind5(size);
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("uf1 spend " + ufTest(uf1, m) + " s");
        System.out.println("uf2 spend " + ufTest(uf2, m) + " s");
        System.out.println("uf3 spend " + ufTest(uf3, m) + " s");
        System.out.println("uf4 spend " + ufTest(uf4, m) + " s");
        System.out.println("uf5 spend " + ufTest(uf5, m) + " s");
        System.out.println("uf6 spend " + ufTest(uf6, m) + " s");
    }
}