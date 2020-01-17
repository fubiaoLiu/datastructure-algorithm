package algorithm.sort;

/**
 * @description: 插入排序: 优化1 - 挪动代替交换
 * @author: FuBiaoLiu
 * @date: 2020/1/17
 */
public class InsertionSort1<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int length = array.length;
        for (int begin = 1; begin < length; begin++) {
            int cur = begin;
            E tmp = array[cur];
            while (cur > 0 && cmp(tmp, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = tmp;
        }
    }
}
