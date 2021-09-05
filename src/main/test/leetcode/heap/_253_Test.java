package leetcode.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fubiao.Liu
 * @since 2020/12/9 15:39
 **/
public class _253_Test {
    _253_会议室2 obj = new _253_会议室2();

    @Test
    public void test1() {
        int[][] nums = {{0, 30}, {5, 10}, {15, 20}};
        int expected = 2;
        int actual = obj.meetingRoom(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] nums = {{7, 10}, {2, 4}};
        int expected = 1;
        int actual = obj.meetingRoom(nums);
        assertEquals(expected, actual);
    }
}