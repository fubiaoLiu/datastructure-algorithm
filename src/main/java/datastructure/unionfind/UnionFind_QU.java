package datastructure.unionfind;

/**
 * @description: 并查集 - Quick Union
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public class UnionFind_QU extends UnionFind {
    public UnionFind_QU(int capacity) {
        super(capacity);
    }

    int find(int v) {
        rangCheck(v);

        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) {
            return;
        }
        parents[root1] = root2;
    }
}
