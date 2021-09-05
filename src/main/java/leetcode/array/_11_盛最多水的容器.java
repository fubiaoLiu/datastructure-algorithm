package leetcode.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 * <p>
 * Related Topics 数组 双指针
 * <p>
 * https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author Fubiao.Liu
 * @since 2021/2/4 17:59
 **/
public class _11_盛最多水的容器 {

    /**
     * 3、双指针：从两侧较短的柱子开始向内收缩，如果收缩后的下一个柱子比当前侧最高的要矮，直接跳过
     * 代码优化
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            int width = r - l;
            int low;
            if (height[l] < height[r]) {
                low = height[l];
                while (height[++l] <= low && l < r) {
                }
            } else {
                low = height[r];
                while (height[--r] <= low && l < r) {
                }
            }
            maxArea = Math.max(maxArea, low * width);
        }
        return maxArea;
    }

    /**
     * 2、双指针：从两侧较短的柱子开始向内收缩，如果收缩后的下一个柱子比当前侧最高的要矮，直接跳过
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lHighest = 0, rHighest = 0;
        int maxArea = 0;
        while (l < r) {
            int width = r - l;
            int low;
            if (height[l] < height[r]) {
                low = height[l++];
                while (height[l] <= lHighest && l < r) {
                    l++;
                }
                lHighest = height[l];
            } else {
                low = height[r--];
                while (height[r] <= rHighest && l < r) {
                    r--;
                }
                rHighest = height[r];
            }
            maxArea = Math.max(maxArea, low * width);
        }
        return maxArea;
    }

    /**
     * 1、双指针：从两侧较短的柱子开始向内收缩
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int width = r - l;
            int low = height[l] < height[r] ? height[l++] : height[r--];
            maxArea = Math.max(maxArea, low * width);
        }
        return maxArea;
    }
}
