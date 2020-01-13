package other.heap;

import org.junit.jupiter.api.Test;
import tree.printer.BinaryTrees;

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
        BinaryTrees.print(heap);
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
}
