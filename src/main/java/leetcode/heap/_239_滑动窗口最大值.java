package leetcode.heap;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * Related Topics 堆 Sliding Window
 * <p>
 * https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * @author Fubiao.Liu
 * @since 2020/12/9 15:40
 **/
public class _239_滑动窗口最大值 {
    /**
     * 新的滑动窗口拿最右边的索引位置的值和已知的最大索引位置的值进行比较
     * 最差情况，时间复杂度为O(kn)，目前leetcode运行这个代码效率很差，推荐还是双端队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return null;
        }
        if (nums.length <= 1 || k == 1) {
            return nums;
        }
        int[] maxs = new int[nums.length - k + 1];
        // 先获取前k个元素的最大值
        int maxIds = getMaxIds(nums, 0, k - 1);
        maxs[0] = nums[maxIds];
        for (int li = 1; li < maxs.length; li++) {
            int ri = li + k - 1;
            if (nums[ri] > nums[maxIds]) {
                maxIds = ri;
            } else if (maxIds < li) {
                maxIds = getMaxIds(nums, li, ri);
            }
            maxs[li] = nums[maxIds];
        }
        return maxs;
    }

    /**
     * 获取滑动窗口中最大值的索引
     *
     * @param nums 数组
     * @param li   滑动窗口最左索引
     * @param ri   滑动窗口最右索引
     * @return 滑动窗口中最大值的索引
     */
    private int getMaxIds(int[] nums, int li, int ri) {
        int maxIds = li++;
        for (; li <= ri; li++) {
            if (nums[li] >= nums[maxIds]) {
                maxIds = li;
            }
        }
        return maxIds;
    }

    /**
     * 基于双端队列（单调队列）实现，队列单调递减
     * 时间复杂度大约为O(n)
     */
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        if (nums == null || k < 1) {
            return null;
        }
        if (nums.length <= 1 || k == 1) {
            return nums;
        }
        int[] maxs = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int ri = 0; ri < nums.length; ri++) {
            while (true) {
                if (deque.isEmpty() || nums[deque.getLast()] > nums[ri]) {
                    deque.add(ri);
                    break;
                } else {
                    deque.removeLast();
                }
            }
            int li = ri - k + 1;
            if (li < 0) {
                continue;
            }
            while (deque.getFirst() < li) {
                deque.removeFirst();
            }
            maxs[li] = nums[deque.getFirst()];
        }
        return maxs;
    }
}