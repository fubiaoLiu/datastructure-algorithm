package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

public class _16_16_Test {
    _16_16_部分排序 subSort = new _16_16_部分排序();

    @Test
    public void test1() {
        int[] num = {1, 6, 5, 4, 3, 6, 7};
        int[] ints = subSort.subSort(num);
        int[] expected = {1, 4};
        assertArrayEquals(expected, ints);
    }

    @Test
    public void test2() {
        int[] num = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] ints = subSort.subSort(num);
        int[] expected = {3, 9};
        assertArrayEquals(expected, ints);
    }
}