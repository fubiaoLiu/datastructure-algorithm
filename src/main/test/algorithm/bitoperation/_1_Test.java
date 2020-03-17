package algorithm.bitoperation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _1_Test {
    _1_其他数都出现了k次的数组中找到只出现一次的数 onceNum = new _1_其他数都出现了k次的数组中找到只出现一次的数();

    @Test
    public void should_success_test_find_once_num1() {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5};
        int k = 3;
        assertThat(onceNum.onceNum(arr, k)).isEqualTo(3);
    }

    @Test
    public void should_success_test_find_once_num2() {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 1, 2, 3,};
        int k = 4;
        assertThat(onceNum.onceNum(arr, k)).isEqualTo(4);
    }
}
