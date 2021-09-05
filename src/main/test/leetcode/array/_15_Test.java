package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Assertions.assertListEquals;

public class _15_Test {
    _15_三数之和 obj = new _15_三数之和();

    @Test
    public void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> actual = obj.threeSum(nums);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertListEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void test2() {
        int[] nums = {};
        List<List<Integer>> actual = obj.threeSum(nums);
        assertNotNull(actual);
        assertEquals(0, actual.size());
    }

    @Test
    public void test3() {
        int[] nums = {0};
        List<List<Integer>> actual = obj.threeSum(nums);
        assertNotNull(actual);
        assertEquals(0, actual.size());
    }

    @Test
    public void test4() {
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, 0, 2));
        expected.add(Arrays.asList(-2, 1, 1));
        List<List<Integer>> actual = obj.threeSum(nums);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertListEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void test5() {
        int[] nums = {-2, -1, -1, 0, 2};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, 0, 2));
        expected.add(Arrays.asList(-1, -1, 2));
        List<List<Integer>> actual = obj.threeSum(nums);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertListEquals(expected.get(i), actual.get(i));
        }
    }
}
