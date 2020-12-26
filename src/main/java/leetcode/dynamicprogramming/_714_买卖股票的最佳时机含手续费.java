package leetcode.dynamicprogramming;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * Related Topics 贪心算法 数组 动态规划
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 *
 * @author Fubiao.Liu
 * @since 2020/12/18 14:23
 **/
public class _714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1 || fee < 0) {
            return 0;
        }
        int profit = 0;
        int max = prices[0];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] <= min || max - prices[i] > fee) {
                // 比前面最低的还便宜，或比前一天跌幅超过手续费的值，看看前面买卖一次是否有赚
                profit += Math.max(max - min - fee, 0);
                min = max = prices[i];
            }
        }
        profit += Math.max(max - min - fee, 0);
        return profit;
    }
}
