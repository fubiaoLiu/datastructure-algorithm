package algorithm.sort;

/**
 * 插入排序
 *
 * @author FuBiaoLiu
 * @since 2020/1/17
 */
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int length = array.length;
        for (int begin = 1; begin < length; begin++) {
            /*for (int j = begin; j > 0; j--) {
                if (cmp(j, j - 1) < 0) {
                    swap(j, j - 1);
                }
            }*/
            int cur = begin;
            while (cur > 0 && (cmp(cur, cur - 1) < 0)) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
