package datastructure.unionfind;

/**
 * @description: 并查集抽象类
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public abstract class UnionFind {
    protected int[] parents;

    public UnionFind(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must > 0.");
        }

        parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
        }
    }

    abstract int find(int v);

    protected void rangCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new ArrayIndexOutOfBoundsException("v not exist.");
        }
    }

    abstract void union(int v1, int v2);

    boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }
}
