package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _912_Test {
    _912_排序树组 sort = new _912_排序树组();

    @Test
    public void test1() {
        int[] nums = {6, 7, 2, 5, 4};
        int[] result = sort.sortArray(nums);
        assertThat(result.length).isEqualTo(5);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(4);
        assertThat(result[2]).isEqualTo(5);
        assertThat(result[3]).isEqualTo(6);
        assertThat(result[4]).isEqualTo(7);
    }

    @Test
    public void test2() {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = sort.sortArray(nums);
        assertThat(result.length).isEqualTo(6);
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(1);
        assertThat(result[4]).isEqualTo(2);
        assertThat(result[5]).isEqualTo(5);
    }
}
