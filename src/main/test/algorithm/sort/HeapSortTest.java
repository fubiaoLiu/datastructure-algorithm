package algorithm.sort;

import algorithm.sort.tools.Integers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapSortTest {
    @Test
    public void should_success_given_random() {
        Integer[] array = Integers.random(1000, 1, 1000);
        new HeapSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_asc_Order() {
        Integer[] array = Integers.ascOrder(1, 1000);
        new HeapSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_desc_Order() {
        Integer[] array = Integers.descOrder(1, 1000);
        new HeapSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }
}
