package datastructure.unionfind;

/**
 * 并查集 - Quick Union - Rank优化 - 路径分裂优化
 *
 * @author FuBiaoLiu
 * @since 2020/1/24
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {
    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    int find(int v) {
        while (v != parents[v]) {
            int p = parents[v];
            parents[v] = parents[p];
            v = p;
        }
        return v;
    }
}
