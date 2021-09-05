package algorithm.math;

/**
 * 请设计一个算法求x的y次幂模z的结果：(x ^ y) % z
 * 假设x，y都可能是很大的整数
 * y >= 0，z != 0
 * <p>
 * 公式：(a * b) % p == ((a % p) * (b % p)) % p
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 17:17
 **/
public class FastPower {
    public long fastPower(long x, long y, long z) {
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x % z;
        }
        long half = fastPower(x, y >> 1, z);
        long surplus = fastPower(x, y & 1, z);
        // return (half * half * surplus) % z;
        half %= z;
        surplus %= z;
        return (((half * half) % z) * surplus) % z;
    }
}
