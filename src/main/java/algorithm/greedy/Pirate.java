package algorithm.greedy;

import java.util.Arrays;

/**
 * @description: 最优装载问题（加勒比海盗）
 * 有一天，海盗们截获了一艘装满各种各样古董的货船，每一件古董都价值连城，一旦打碎就失去了它的价值
 * 海盗船的载重量为 W，每件古董的重量为 𝑤i，海盗们该如何把尽可能多数量的古董装上海盗船？
 * 比如 W 为 30，𝑤i 分别为 3、5、4、10、7、14、2、11
 * @author FuBiaoLiu
 * @since 2020/2/4
 */
public class Pirate {
    /**
     * 贪心策略 - 每次优先选择重量最小的古董
     *
     * @param weights
     * @param capacity
     * @return
     */
    public int pirate(int[] weights, int capacity) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        Arrays.sort(weights);
        int num = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                break;
            }
            num++;
            capacity -= weight;
        }
        return num;
    }
}
