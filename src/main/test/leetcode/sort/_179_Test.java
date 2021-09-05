package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _179_Test {
    _179_最大数 obj = new _179_最大数();

    @Test
    public void test1() {
        int[] nums = {10, 2};
        String expected = "210";
        String actual = obj.largestNumber(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {3, 30, 34, 5, 9};
        String expected = "9534330";
        String actual = obj.largestNumber(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {1};
        String expected = "1";
        String actual = obj.largestNumber(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = {10};
        String expected = "10";
        String actual = obj.largestNumber(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = {0,0};
        String expected = "0";
        String actual = obj.largestNumber(nums);
        assertEquals(expected, actual);
    }
}