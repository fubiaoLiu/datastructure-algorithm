package algorithm.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _FastPowerTest {
    FastPower obj = new FastPower();

    @Test
    public void test1() {
        long x = 5, y = 2, z = 3;
        long expected = 1;
        long actual = obj.fastPower(x, y, z);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        long x = -123, y = 455, z = 789;
        long expected = -57;
        long actual = obj.fastPower(x, y, z);
        assertEquals(expected, actual);
    }
}
