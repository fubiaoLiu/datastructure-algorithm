package datastructure.unionfind;

/**
 * @description: 并查集 - Quick Union - 基于Size优化
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public class UnionFind_QU_S extends UnionFind_QU {
    private int[] sizes;

    public UnionFind_QU_S(int capacity) {
        super(capacity);

        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1;
        }
    }

    @Override
    void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) {
            return;
        }

        if (sizes[root1] <= sizes[root2]) {
            parents[root1] = root2;
            sizes[root2] += sizes[root1];
        } else {
            parents[root2] = root1;
            sizes[root1] += sizes[root2];
        }
    }
}
