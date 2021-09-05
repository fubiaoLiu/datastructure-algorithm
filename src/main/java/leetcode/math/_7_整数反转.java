package leetcode.math;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 * <p>
 * Related Topics 数学
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer
 *
 * @author Fubiao.Liu
 * @since 2021/2/3 9:54
 **/
public class _7_整数反转 {
    /**
     * 3、long存储转换结果，最后对比结果强转为int后是否一致，不一致则返回0，否则返回结果值
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        return (int) result == result ? (int) result : 0;
    }

    /**
     * 1、反向计算结果是否一致（溢出后反向计算结果不同）
     * 反复计算两次，效率略差
     */
    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            int mod = x % 10;
            res = prevRes * 10 + mod;
            if ((res - mod) / 10 != prevRes) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }

    /**
     * 2、long存储转换结果，如果超出int范围，直接返回0
     */
    public int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) result;
    }
}
