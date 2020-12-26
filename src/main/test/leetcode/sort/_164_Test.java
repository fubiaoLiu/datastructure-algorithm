package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _164_Test {
    _164_最大间距 maximumGap = new _164_最大间距();

    @Test
    public void test1() {
        int[] nums = {1, 2, 0, 2, 1, 1};
        int result = maximumGap.maximumGap(nums);

        assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] nums = {3, 6, 9, 1};
        int result = maximumGap.maximumGap(nums);

        assertEquals(3, result);
    }

    @Test
    public void test3() {
        int[] nums = {1};
        int result = maximumGap.maximumGap(nums);

        assertEquals(0, result);
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 1, 1};
        int result = maximumGap.maximumGap(nums);

        assertEquals(0, result);
    }

    @Test
    public void test5() {
        int[] nums = {15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521,
                6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683,
                23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740};
        int result = maximumGap.maximumGap(nums);

        assertEquals(2901, result);
    }
}