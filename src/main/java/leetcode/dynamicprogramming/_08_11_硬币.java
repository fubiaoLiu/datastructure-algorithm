package leetcode.dynamicprogramming;


/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 示例2:
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 说明：
 * 注意:
 * 你可以假设：0 <= n (总金额) <= 1000000
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/coin-lcci
 *
 * @author Fubiao.Liu
 * @since 2020/12/16 14:09
 **/
public class _08_11_硬币 {
    int mod = 1000000007;
    int[] coins = {25, 10, 5, 1};

    /**
     * 动态规划：一维数组
     * 空间复杂度：O(n)
     */
    public int waysToChange(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j - coin] + dp[j]) % mod;
            }
        }
        return dp[n];
    }

    /**
     * 动态规划：二维数组
     * 空间复杂度：O(4n)
     */
    public int waysToChange2(int n) {
        int[] coins = {1, 5, 10, 25};
        if (n < coins[0]) {
            return 0;
        }
        int[][] dp = new int[n + 1][coins.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < coins.length; j++) {
                dp[i][j] = (i < coins[j] ? dp[i][j - 1] : ((i == coins[j] ? 1 : dp[i - coins[j]][j]) + dp[i][j - 1])) % mod;
            }
        }
        return dp[n][coins.length - 1];
    }

    /**
     * 超时时间限制：StackOverflowError
     */
    public int waysToChange1(int n) {
        int[] coins = {1, 5, 10, 25};
        return n < coins[0] ? 0 : waysToChange1(n, coins.length - 1, coins);
    }

    private int waysToChange1(int n, int maxIndex, int[] coins) {
        if (n == 0) {
            return 1;
        }
        if (maxIndex < 0) {
            return 0;
        }
        return waysToChange1(n, maxIndex - 1, coins) + (n >= coins[maxIndex] ? waysToChange1(n - coins[maxIndex], maxIndex, coins) : 0);
    }

    /**
     * 未通过测试
     */
    public int waysToChangeHis(int n) {
        if (n < coins[0]) {
            return 0;
        }
        int max = n + 1;
        int[] dp = new int[max];
        dp[1] = 1;
        for (int i = 2; i < max; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                dp[i] += (i == coin ? 1 : dp[i - coin]);
            }
        }
        return dp[n];
    }
}