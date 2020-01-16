package datastructure.heap;

import org.junit.jupiter.api.Test;
import datastructure.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryHeapTest {
    @Test
    public void should_success_add_get() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }

        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(96);
        BinaryTrees.println(heap);
    }

    @Test
    public void should_success_remove() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(96);
        BinaryTrees.println(heap);

        assertThat(heap.remove()).isEqualTo(96);
        assertThat(heap.size()).isEqualTo(13);
        assertThat(heap.get()).isEqualTo(86);
        BinaryTrees.println(heap);
    }


    @Test
    public void should_success_clear() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(96);
        BinaryTrees.println(heap);

        heap.clear();
        assertThat(heap.size()).isEqualTo(0);
    }

    @Test
    public void should_success_replace() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(96);
        BinaryTrees.println(heap);

        heap.replace(97);
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(97);
        BinaryTrees.println(heap);

        heap.replace(1);
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(86);
        BinaryTrees.println(heap);
    }

    @Test
    public void should_return_96_79_86_Top3() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < data.length; i++) {
            if (i < 3) {
                heap.add(data[i]);
            } else {
                int root = heap.get();
                if (data[i] > root) {
                    heap.replace(data[i]);
                }
            }
        }
        assertThat(heap.size()).isEqualTo(3);
        assertThat(heap.get()).isEqualTo(79);
        BinaryTrees.println(heap);
    }

    @Test
    public void should_return_96_86_Top2() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < data.length; i++) {
            if (i < 2) {
                heap.add(data[i]);
            } else {
                int root = heap.get();
                if (data[i] > root) {
                    heap.replace(data[i]);
                }
            }
        }
        assertThat(heap.size()).isEqualTo(2);
        assertThat(heap.get()).isEqualTo(86);
        BinaryTrees.println(heap);
    }

    @Test
    public void should_success_add_batch() {
        Integer[] data = new Integer[]{86, 64, 96, 29, 79, 42, 13, 63, 39, 5, 56, 67, 50, 51};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        assertThat(heap.size()).isEqualTo(14);
        assertThat(heap.get()).isEqualTo(96);
        BinaryTrees.println(heap);
    }

    @Test
    public void should_fail_add_batch_bottom_up1() {
        Integer[] data = new Integer[]{60, 46, 95, 38, 76, 43, 11, 78, 36, 56, 40, 61, 42, 97, 53, 75, 99};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
//        assertThat(heap.size()).isEqualTo(17);
//        assertThat(heap.get()).isEqualTo(99);
        BinaryTrees.println(heap);
    }

    @Test
    public void sort_arr_with_heap() {
        Integer[] data = new Integer[]{60, 46, 95, 38, 76, 43, 11, 78, 36, 56, 40, 61, 42, 97, 53, 75, 99};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryTrees.println(heap);

        for (int i = 0; i < data.length; i++) {
            data[i] = heap.remove();
        }

        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < data.length; i++) {
            joiner.add(data[i].toString());
        }
        assertThat(joiner.toString()).isEqualTo("[99,97,95,78,76,75,61,60,56,53,46,43,42,40,38,36,11]");
        System.out.println(joiner.toString());
    }

    /**
     * 原地排序(利用小顶堆，排序后元素从大到小)
     */
    @Test
    public void sort_arr_in_situ() {
        Integer[] data = new Integer[]{60, 46, 95, 38, 76, 43, 11, 78, 36, 56, 40, 61, 42, 97, 53, 75, 99};
        heapify(data);

        for (int i = data.length - 1; i > 0; i--) {
            int tmp = data[0];
            data[0] = data[i];
            data[i] = tmp;
            siftDown(data, i - 1, 0);
        }

        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Integer[] mockData = new Integer[]{99, 97, 95, 78, 76, 75, 61, 60, 56, 53, 46, 43, 42, 40, 38, 36, 11};
        for (int i = 0; i < data.length; i++) {
            assertThat(data[i]).isEqualTo(mockData[i]);
            joiner.add(data[i].toString());
        }
        System.out.println(joiner.toString());
    }

    private void heapify(Integer[] elements) {
        // 自下而上的下滤
        for (int i = (elements.length >> 1) - 1; i >= 0; i--) {
            siftDown(elements, elements.length, i);
        }
    }

    private void siftDown(Integer[] elements, int length, int index) {
        int element = elements[index];
        int half = length >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = elements[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < length && compare(child, elements[rightIndex]) < 0) {
                child = elements[childIndex = rightIndex];
            }

            if (compare(element, child) >= 0) {
                break;
            }
            elements[index] = elements[childIndex];
            index = childIndex;
        }
        elements[index] = element;
    }

    private int compare(int e1, int e2) {
        return e2 - e1;
    }
}
