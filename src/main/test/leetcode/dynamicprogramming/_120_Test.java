package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description: _120_三角形最小路径和测试类
 * @author: liufb
 * @create: 2020/5/18 10:32
 **/
public class _120_Test {
    _120_三角形最小路径和 minPath = new _120_三角形最小路径和();

    @Test
    public void test() {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> childList1 = new ArrayList<>();
        childList1.add(2);
        List<Integer> childList2 = new ArrayList<>();
        childList2.add(3);
        childList2.add(4);
        List<Integer> childList3 = new ArrayList<>();
        childList3.add(6);
        childList3.add(5);
        childList3.add(7);
        List<Integer> childList4 = new ArrayList<>();
        childList4.add(4);
        childList4.add(1);
        childList4.add(8);
        childList4.add(3);
        triangle.add(childList1);
        triangle.add(childList2);
        triangle.add(childList3);
        triangle.add(childList4);
        assertThat(minPath.minimumTotal(triangle)).isEqualTo(11);
    }
}
