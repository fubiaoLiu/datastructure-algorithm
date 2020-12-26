package leetcode.dynamicprogramming;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * Related Topics 数组 动态规划
 * <p>
 * https://leetcode-cn.com/problems/triangle
 *
 * @author liufb
 * @create: 2020/5/18 11:03
 **/
public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = new int[length];
        dp[0] = triangle.get(0).get(0);
        List<Integer> childList;
        for (int i = 1; i < triangle.size(); i++) {
            childList = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += childList.get(j);
                } else if (j == i) {
                    dp[j] = childList.get(j) + dp[j - 1];
                } else {
                    dp[j] = childList.get(j) + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
