package algorithm.sort;

/**
 * @description: 堆排序
 * @author FuBiaoLiu
 * @since 2020/1/17
 */
public class HeapSort<E extends Comparable<E>> extends Sort<E> {
    private int heapSize;

    @Override
    protected void sort() {
        heapSize = array.length;
        heapify();

        while (heapSize > 1) {
            swap(0, --heapSize);
            siftDown(0);
        }

    }

    /**
     * 原地建堆
     */
    private void heapify() {
        // 自下而上的下滤
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 下滤
     *
     * @param index
     */
    private void siftDown(int index) {
        E element = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = array[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < heapSize && cmp(child, array[rightIndex]) < 0) {
                child = array[childIndex = rightIndex];
            }

            if (cmp(element, child) >= 0) {
                break;
            }
            array[index] = array[childIndex];
            index = childIndex;
        }
        array[index] = element;
    }
}
