package algorithm.sort;

/**
 * @description: 选择排序
 * @author: FuBiaoLiu
 * @date: 2020/1/17
 */
public class SelectionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0) {
                    max = begin;
                }
            }
            if (max != end) {
                swap(max, end);
            }
        }
    }
}
