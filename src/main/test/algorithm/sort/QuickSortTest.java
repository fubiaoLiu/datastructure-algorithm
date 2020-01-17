package algorithm.sort;

import algorithm.sort.tools.Integers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
    @Test
    public void should_success_given_random() {
        Integer[] array = Integers.random(1000, 1, 1000);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_asc() {
        Integer[] array = Integers.ascOrder(1, 1000);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_desc() {
        Integer[] array = Integers.descOrder(1, 1000);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_head_asc() {
        Integer[] array = Integers.headAscOrder(1, 1000, 500);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_tail_asc() {
        Integer[] array = Integers.tailAscOrder(1, 1000, 500);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_given_head_tail_asc() {
        Integer[] array = Integers.headTailAscOrder(1, 1000, 500);
        new QuickSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

}
