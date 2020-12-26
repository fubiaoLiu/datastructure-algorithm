package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1235_Test {
    _1235_规划兼职工作 obj = new _1235_规划兼职工作();

    @Test
    public void test1() {
        int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
        assertEquals(120, obj.jobScheduling(startTime, endTime, profit));
        assertEquals(120, obj.jobScheduling1(startTime, endTime, profit));
    }

    @Test
    public void test2() {
        int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
        assertEquals(150, obj.jobScheduling(startTime, endTime, profit));
        assertEquals(150, obj.jobScheduling1(startTime, endTime, profit));
    }

    @Test
    public void test3() {
        int[] startTime = {1, 1, 1}, endTime = {2, 3, 4}, profit = {5, 6, 4};
        assertEquals(6, obj.jobScheduling(startTime, endTime, profit));
        assertEquals(6, obj.jobScheduling1(startTime, endTime, profit));
    }

    @Test
    public void test4() {
        int[] startTime = {6, 15, 7, 11, 1, 3, 16, 2}, endTime = {19, 18, 19, 16, 10, 8, 19, 8}, profit = {2, 9, 1, 19, 5, 7, 3, 19};
        assertEquals(41, obj.jobScheduling(startTime, endTime, profit));
        assertEquals(41, obj.jobScheduling1(startTime, endTime, profit));
    }

    @Test
    public void test5() {
        int[] startTime = {1, 5, 5, 10}, endTime = {4, 8, 9, 15}, profit = {1, 100, 10, 5};
        assertEquals(106, obj.jobScheduling(startTime, endTime, profit));
        assertEquals(106, obj.jobScheduling1(startTime, endTime, profit));
    }
}