package leetcode.math;

import java.util.Arrays;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * <p>
 * 公式：f(n,m) = (f(n-1,m) + m) % n
 * 这就是著名的约瑟夫环问题
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 17:41
 **/
public class _62_圆圈中最后剩下的数字 {

    /**
     * 公式：循环
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n ; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    /**
     * 公式：递归
     * n太大会栈溢出
     */
    public int lastRemaining2(int n, int m) {
        return n == 0 ? 0 : (lastRemaining2(n - 1, m) + m) % n;
    }

    /**
     * 模拟真实情况，一步步推演，时间复杂度过高：O(m * n ^ 2)
     */
    public int lastRemaining1(int n, int m) {
        boolean[] lives = new boolean[n];
        Arrays.fill(lives, true);
        int liveCount = n;
        int cur = -1;
        while (liveCount > 1) {
            for (int i = 0; i < m; i++) {
                do {
                    if (++cur == n) {
                        cur = 0;
                    }
                } while (!lives[cur]);
            }
            lives[cur] = false;
            liveCount--;
        }
        do {
            if (++cur == n) {
                cur = 0;
            }
        } while (!lives[cur]);
        return cur;
    }
}
