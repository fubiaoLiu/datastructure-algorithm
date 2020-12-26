package algorithm.sort;

/**
 * @description: 冒泡排序：优化2 - 数组局部有序的情况
 * @author FuBiaoLiu
 * @since 2020/1/16
 */
public class BubbleSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    public void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
