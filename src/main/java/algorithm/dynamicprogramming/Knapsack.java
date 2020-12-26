package algorithm.dynamicprogramming;

/**
 * 0-1背包
 * 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i
 * 在保证总重量不超过 W 的前提下，选择某些物品装入背包，背包的最大总价值是多少？
 * 注意：每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件
 * <p>
 * 假设 values 是价值数组，weights 是重量数组
 * 编号为 k 的物品，价值是 values[k]，重量是 weights[k]，k ∈ [0, n)
 *
 * @author FuBiaoLiu
 * @since 2020/2/6
 */
public class Knapsack {
    /**
     * 恰好装满
     *
     * @param values   物品价值
     * @param weights  物品重量
     * @param capacity 背包容量
     * @return
     */
    public int justFillUp(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }
        if (weights.length != values.length) {
            return 0;
        }
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    /**
     * 动态规划 - 优化2 - 一维数组代码优化
     *
     * @param values   物品价值
     * @param weights  物品重量
     * @param capacity 背包容量
     * @return
     */
    public int select(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }
        if (weights.length != values.length) {
            return 0;
        }
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    /**
     * 动态规划 - 优化1 - 一维数组
     *
     * @param values   物品价值
     * @param weights  物品重量
     * @param capacity 背包容量
     * @return
     */
    public int select2(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }
        if (weights.length != values.length) {
            return 0;
        }
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (weights[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[capacity];
    }

    /**
     * 动态规划 - 多维数组
     *
     * @param values   物品价值
     * @param weights  物品重量
     * @param capacity 背包容量
     * @return
     */
    public int select1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }
        if (weights.length != values.length) {
            return 0;
        }
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - weights[i - 1]] + values[i - 1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return dp[values.length][capacity];
    }
}
