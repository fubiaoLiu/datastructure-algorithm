package algorithm.greedy;

import java.util.Arrays;

/**
 * @description: 零钱兑换
 * 假设有 25 分、10 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
 * @author FuBiaoLiu
 * @since 2020/2/4
 */
public class CoinChange {
    /**
     * 贪心策略：每一次都优先选择面值最大的硬币
     *
     * @param faces
     * @param money
     * @return
     */
    public int change1(int[] faces, int money) {
        if (faces == null || faces.length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < faces.length; ) {
            if (faces[i] > money) {
                i++;
                continue;
            }
            num++;
            money -= faces[i];
        }
        return money == 0 ? num : -1;
    }

    /**
     * 贪心策略：每一次都优先选择面值最大的硬币
     *
     * @param faces
     * @param money
     * @return
     */
    public int change2(int[] faces, int money) {
        if (faces == null || faces.length == 0) {
            return 0;
        }
        Arrays.sort(faces);
        int num = 0;
        int idx = faces.length - 1;
        while (idx >= 0) {
            while (money >= faces[idx]) {
                money -= faces[idx];
                num++;
            }
            idx--;
        }
        return money == 0 ? num : -1;
    }
}
