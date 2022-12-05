public class UnionFind1 implements UF {
    private int[] id;
    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i ++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    // 查看p，q是否属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并p，q所属的集合
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qid = find(q);
        if (pId == qid) {
            return;
        }
        for (int i = 0; i < id.length; i ++) {
            if (id[i] == pId) {
                id[i] = qid;
            }
        }
    }
}