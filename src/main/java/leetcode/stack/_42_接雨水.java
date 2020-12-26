package leetcode.stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * <p>
 * Related Topics 栈 数组 双指针
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water
 *
 * @author Fubiao.Liu
 * @since 2020/12/10 9:09
 **/
public class _42_接雨水 {
    /**
     * 计算每个柱子左右两边比它高的最高的柱子
     * 1、两边最高的柱子的最小高度减去当前柱子的高度就是积水的高度
     * 2、如果任一一边没有比它高的柱子，则不能积水
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int[] lis = new int[height.length];
        int[] ris = new int[height.length];
        int lMaxIds = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[lMaxIds] <= height[i]) {
                lMaxIds = i;
                lis[i] = -1;
            } else {
                lis[i] = lMaxIds;
            }
        }
        int rMaxIds = height.length - 1;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[rMaxIds] <= height[i]) {
                rMaxIds = i;
                ris[i] = -1;
            } else {
                ris[i] = rMaxIds;
            }
        }
        int value = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] != -1 && ris[i] != -1) {
                value += Math.min(height[lis[i]], height[ris[i]]) - height[i];
            }
        }
        return value;
    }

    /*public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int[] lis = new int[height.length];
        int[] ris = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            lis[i] = -1;
            ris[i] = -1;
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }
        int value = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] != -1 && ris[i] != -1) {
                value += Math.min(height[lis[i]], height[ris[i]]) - height[i];
            }
        }
        return value;
    }*/
}