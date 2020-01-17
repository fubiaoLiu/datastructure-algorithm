package algorithm.sort;

/**
 * @description: 冒泡排序
 * @author: FuBiaoLiu
 * @date: 2020/1/16
 */
public class BubbleSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    public void sort() {
        for (int end = array.length; end > 0; end--) {
            for (int begin = 1; begin < end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
