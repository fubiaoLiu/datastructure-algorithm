package leetcode.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 不考虑精度丢失问题，所以部分情况要处理程序结果的精度再断言验证
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 17:08
 **/
public class _50_Test {
    _50_Pow obj = new _50_Pow();

    @Test
    public void test1() {
        double x = 2.00000;
        int n = 10;
        double expected = 1024.00000;
        double actual = obj.myPow(x, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        double x = 2.10000;
        int n = 3;
        double expected = 9.26100;
        double actual = obj.myPow(x, n);
        // 保留5位小数
        actual = new BigDecimal(actual).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        double x = 2.00000;
        int n = -2;
        double expected = 0.25000;
        double actual = obj.myPow(x, n);
        assertEquals(expected, actual);
    }
}
