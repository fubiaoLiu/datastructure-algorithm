package leetcode.dynamicprogramming;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * Related Topics 数组 动态规划
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 17:29
 **/
public class _121_买股票的最佳时机 {
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int rMax = prices[prices.length - 1];
        int max = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] >= rMax) {
                rMax = prices[i];
            } else {
                max = Math.max(max, rMax - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // dp[i][j]表示第i天买，第j天卖的盈亏
        // dp[i][j] = dp[i][j - 1] + prices[j] - prices[j - 1]
        // dp[i][j] = dp[i - 1][j] - prices[i] + prices[i - 1]
        int[][] dp = new int[prices.length][prices.length];
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            dp[i][i] = 0;
            for (int j = i + 1; j < prices.length; j++) {
                dp[i][j] = dp[i][j - 1] + prices[j] - prices[j - 1];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // dp[i][j]表示第i天买，第j天卖的盈亏
        // dp[i][j] = dp[i][j - 1] + prices[j] - prices[j - 1]
        // dp[i][j] = dp[i - 1][j] - prices[i] + prices[i - 1]
        int[] dp = new int[prices.length];
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            dp[i] = 0;
            for (int j = i + 1; j < prices.length; j++) {
                dp[j] = dp[j - 1] + prices[j] - prices[j - 1];
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}