package datastructure.unionfind;

/**
 * @description: 并查集 - Quick Find
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    int find(int v) {
        rangCheck(v);
        return parents[v];
    }

    void union(int v1, int v2) {
        int parent1 = parents[v1];
        int parent2 = parents[v2];
        if (parent1 == parent2) {
            return;
        }

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == parent1) {
                parents[i] = parent2;
            }
        }
    }
}
