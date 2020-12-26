package algorithm.sort;

/**
 * 快速排序
 *
 * @author FuBiaoLiu
 * @since 2020/1/17
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        int pivot = pivotIndex(begin, end);
        sort(begin, pivot);
        sort(pivot + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        E pivot = array[begin];
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivot;
        return begin;
    }
}
