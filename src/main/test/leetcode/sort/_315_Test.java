package leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static utils.Assertions.assertArrayAndListEquals;

public class _315_Test {
    _315_计算右侧小于当前元素的个数 obj = new _315_计算右侧小于当前元素的个数();

    @Test
    public void test1() {
        int[] num = {5, 2, 6, 1};
        Integer[] expected = {2, 1, 1, 0};
        List<Integer> actual = obj.countSmaller(num);
        assertArrayAndListEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] num = {-1, -1};
        Integer[] expected = {0, 0};
        List<Integer> actual = obj.countSmaller(num);
        assertArrayAndListEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] num = {76,99,51,9,21,84,66,65,36,100,41};
        Integer[] expected = {7,8,4,0,0,4,3,2,0,1,0};
        List<Integer> actual = obj.countSmaller(num);
        assertArrayAndListEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] num = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        Integer[] expected = {10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0};
        Integer[] actualed = {13,27,13,35,15,23,28,1,1,0,14,6,11,8,13,7,17,10,19,13,14,8,12,7,12,3,1,10,0,0,8,4,1,0,4,3,2,0,1,0};
        List<Integer> actual = obj.countSmaller(num);
        assertArrayAndListEquals(expected, actual);
    }
}