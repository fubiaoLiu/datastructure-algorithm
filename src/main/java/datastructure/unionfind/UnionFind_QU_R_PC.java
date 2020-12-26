package datastructure.unionfind;

/**
 * 并查集 - Quick Union - Rank优化 - 路径压缩优化
 *
 * @author FuBiaoLiu
 * @since 2020/1/24
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {
    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    int find(int v) {
        rangCheck(v);
        if (v != parents[v]) {
            parents[v] = find(parents[v]);
//            ranks[v] = 1;
        }
        return parents[v];
    }
}
