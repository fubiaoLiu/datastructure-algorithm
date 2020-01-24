package datastructure.unionfind;

/**
 * @description: 并查集 - Quick Union - Rank优化 - 路径减半优化
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R {
    public UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    @Override
    int find(int v) {
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
}
