package leetcode.dynamicprogramming;

/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * 提示：
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author Fubiao.Liu
 * @since 2020/12/18 14:23
 **/
public class _188_买卖股票的最佳时机4 {

    /**
     * 动态规划（二维数组）
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 0) {
            return 0;
        }
        int days = prices.length;
        if (k >= (days >> 1)) {
            int maxProfit = 0;
            for (int i = 1; i < days; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return maxProfit;
        }
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            // 没有买入过股票，且手头没有持股，则获取的利润为0
            dp[i][0] = 0;
            // 没有买入过股票，不可能持股，用利润负无穷表示这种不可能
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                // 买入
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - price);
                // 卖出
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + price);
            }
        }
        return dp[k][0];
    }

    /**
     * 题解：动态规划（二维数组）
     */
    public int maxProfit1(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        int days = prices.length;
        // 如果k大于等于天数的一半，转换为无限次交易
        if (k >= (days >> 1)) {
            int maxProfit = 0;
            for (int i = 1; i < days; i++) {
                maxProfit += Math.max((prices[i] - prices[i - 1]), 0);
            }
            return maxProfit;
        }
        // 否则定义一个二维数组，表示第k次交易，当前交易状态
        int[][] dp = new int[k + 1][2];
        // 初始化
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                // 处理第K次买入
                dp[i - 1][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price);
                // 处理第K次卖出
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + price);
            }
        }
        return dp[k][0];
    }
}
