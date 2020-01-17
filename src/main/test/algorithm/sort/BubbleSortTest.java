package algorithm.sort;

import algorithm.sort.tools.Integers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortTest {
    @Test
    public void should_success_use_sort() {
        Integer[] array = Integers.random(100, 1, 100);
        new BubbleSort<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_use_sort1() {
        Integer[] array = Integers.random(100, 1, 100);
        new BubbleSort1<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void should_success_use_sort2() {
        Integer[] array = Integers.random(100, 1, 100);
        new BubbleSort2<Integer>().sort(array);
        assertThat(Integers.isAscOrder(array)).isTrue();
    }

    @Test
    public void cmp_random_sort_sort1_sort2() {
        System.out.println("********random********");
        Integer[] array = Integers.random(10000, 1, 10000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    @Test
    public void cmp_asc_sort_sort1_sort2() {
        System.out.println("********ascOrder********");
        Integer[] array = Integers.ascOrder(1, 10000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    @Test
    public void cmp_desc_sort_sort1_sort2() {
        System.out.println("********descOrder********");
        Integer[] array = Integers.descOrder(1, 10000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    @Test
    public void cmp_tail_asc_sort_sort1_sort2() {
        System.out.println("********tailAscOrder********");
        Integer[] array = Integers.tailAscOrder(1, 10000, 5000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    @Test
    public void cmp_head_asc_sort_sort1_sort2() {
        System.out.println("********headAscOrder********");
        Integer[] array = Integers.headAscOrder(1, 10000, 5000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    @Test
    public void cmp_head_tail_asc_sort_sort1_sort2() {
        System.out.println("********headTailAscOrder********");
        Integer[] array = Integers.headTailAscOrder(1, 10000, 5000);
        test_sort_sort1_sort2(array, new BubbleSort(), new BubbleSort1(), new BubbleSort2());
    }

    private void test_sort_sort1_sort2(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(array));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

}
