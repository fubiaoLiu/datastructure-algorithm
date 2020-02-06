package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * https://leetcode-cn.com/problems/coin-change
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/6
 */
public class _322_零钱兑换 {
    /**
     * 递推
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        Arrays.sort(coins);
        int max = amount + 1;
        int[] dp = new int[max];
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    /**
     * 递推（增加零钱的具体面值方案）
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        int max = amount + 1;
        int[] dp = new int[max];
        int[] faces = new int[max];
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
            int min;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                min = dp[i - coin] + 1;
                if (min < dp[i]) {
                    dp[i] = Math.min(dp[i], min);
                    faces[i] = coin;
                }
            }
        }
        print(faces, amount);
        return dp[amount] == max ? -1 : dp[amount];
    }

    private void print(int[] faces, int amount) {
        while (amount > 0 && faces[amount] >= amount) {
            System.out.print(faces[amount] + " ");
            amount = amount - faces[amount];
        }
        System.out.println();
    }

    /**
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (amount < coin) {
                break;
            } else if (amount == coin) {
                return 1;
            }
            dp[coin] = 1;
        }
        coinChange2(amount, coins, dp);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange2(int amount, int[] coins, int[] dp) {
        if (amount < coins[0]) {
            return Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            if (amount == coin) {
                return dp[coin];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                break;
            }
            int v = coinChange2(amount - coin, coins, dp);
            if (v != Integer.MAX_VALUE) {
                min = Math.min(min, v + 1);
            }
        }
        dp[amount] = min;
        return min;
    }

    /**
     * 暴力递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int result = coinChange1(amount, coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChange1(int amount, int[] coins) {
        if (amount < coins[0]) {
            return Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            if (amount == coin) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                break;
            }
            int v = coinChange1(amount - coin, coins);
            if (v != Integer.MAX_VALUE) {
                min = Math.min(min, v + 1);
            }
        }
        return min;
    }
}
