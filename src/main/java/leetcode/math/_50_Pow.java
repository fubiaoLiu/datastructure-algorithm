package leetcode.math;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * Related Topics 数学 二分查找
 * <p>
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 16:21
 **/
public class _50_Pow {
    /**
     * 二分法：递归2
     * n^10 = n^5 * n^5
     * n^9 = n^4 * n^4 * n
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n >> 1);
        return half * half * myPow(x, n & 1);
    }

    /**
     * 二分法：递归
     * n^10 = n^5 * n^5
     * n^9 = n^4 * n^4 * n
     */
    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double surplus = (n & 1) == 1 ? x : 1;
        double half = myPow3(x, n >> 1);
        return half * half * surplus;
    }

    /**
     * 二分法：循环
     * 时间复杂度：O(logn)
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = pow2(x, n >> 1);
        // 是否为奇数
        return half * half * ((n & 1) == 1 ? x : 1);
    }

    public double pow2(double x, int n) {
        long y = (n < 0) ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制位是1，就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return (n < 0) ? (1 / res) : res;
    }

    /**
     * 直接相乘
     */
    public double myPow1(double x, int n) {
        double result = 1;
        x = n > 0 ? x : 1 / x;
        n = Math.abs(n);
        while (n > 0) {
            result *= x;
            n--;
        }
        return result;
    }
}
