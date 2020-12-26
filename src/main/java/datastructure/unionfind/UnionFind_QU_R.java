package datastructure.unionfind;

/**
 * @description: 并查集 - Quick Union - 基于Rank优化
 * @author FuBiaoLiu
 * @since 2020/1/24
 */
public class UnionFind_QU_R extends UnionFind_QU {
    protected int[] ranks;

    public UnionFind_QU_R(int capacity) {
        super(capacity);

        ranks = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    @Override
    void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) {
            return;
        }

        if (ranks[root1] < ranks[root2]) {
            parents[root1] = root2;
        } else if (ranks[root1] > ranks[root2]) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
            ranks[root2]++;
        }
    }
}
