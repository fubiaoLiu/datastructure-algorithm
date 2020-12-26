package algorithm.recursion;

/**
 * 上楼梯(跳台阶)
 * 楼梯有 n 阶台阶，上楼可以一步上 1 阶，也可以一步上 2 阶，走完 n 阶台阶共有多少种不同的走法？
 *
 * @author FuBiaoLiu
 * @since 2020/2/3
 */
public class ClimbStairs {
    /**
     * 递归
     *
     * @param n 台阶数
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 优化 - 同斐波那契数列一样
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
