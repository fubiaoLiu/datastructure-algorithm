package leetcode.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fubiao.Liu
 * @since 2020/12/9 15:39
 **/
public class _252_Test {
    _252_会议室 obj = new _252_会议室();

    @Test
    public void test1() {
        int[][] nums = {{0, 30}, {5, 10}, {15, 20}};
        boolean expected = false;
        boolean actual = obj.meetingRoom(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] nums = {{7, 10}, {2, 4}};
        boolean expected = true;
        boolean actual = obj.meetingRoom(nums);
        assertEquals(expected, actual);
    }
}