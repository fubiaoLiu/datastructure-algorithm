package algorithm.sort;

/**
 * @description: 插入排序: 优化2 - 使用二分搜索定位插入位置
 * @author FuBiaoLiu
 * @since 2020/1/17
 */
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            insert(i, search(i));
        }
    }

    private int search(int index) {
        int begin = 0, mid, end = index;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (cmp(mid, index) <= 0) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private void insert(int source, int dest) {
        E tmp = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = tmp;
    }

}
