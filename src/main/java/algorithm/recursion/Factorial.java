package algorithm.recursion;

/**
 * @description: 求 n 的阶乘
 * @author FuBiaoLiu
 * @since 2020/2/4
 */
public class Factorial {
    /**
     * 普通递归
     *
     * @param n
     * @return
     */
    public int factorial1(int n) {
        if (n <= 1) {
            return n;
        }
        return n * factorial1(n - 1);
    }

    public int factorial2(int n) {
        return factorial2(n, 1);
    }

    public int factorial2(int n, int result) {
        if (n <= 1) {
            return result;
        }
        return factorial2(n - 1, result * n);
    }
}
