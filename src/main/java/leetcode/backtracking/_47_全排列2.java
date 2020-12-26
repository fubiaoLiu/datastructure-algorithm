package leetcode.backtracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * Related Topics 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/permutations-ii
 *
 * @author FuBiaoLiu
 * @since 2020/2/5
 */
public class _47_全排列2 {
    private int[] nums;
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        this.result = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(used, 0, new ArrayDeque<>());
        return result;
    }

    private void dfs(boolean[] used, int depth, Deque<Integer> stack) {
        int pre = nums[0] - 1;
        for (int i = 0; i < len; i++) {
            // 如果当前数字没有使用过 或者 前一个数字等于当前数字并且前一个数字没有使用
            if (used[i] || (nums[i] == pre && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            stack.push(nums[i]);
            if (depth == len - 1) {
                setResult(stack);
            } else {
                dfs(used, depth + 1, stack);
            }
            used[i] = false;
            stack.poll();
            pre = nums[i];
        }
    }

    private void setResult(Deque<Integer> stack) {
        result.add(new ArrayList<>(stack));
    }
    // ------------------第三季练习------------------

    /**
     * 每个元素和其他元素交换一次
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int level) {
        if (level == nums.length) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            // 保证一个数字在level位置只会出现一次
            if (isRepeat(nums, level, i)) {
                continue;
            }
            swap(nums, level, i);
            dfs(result, nums, level + 1);
            swap(nums, level, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 如果level到i之间有和nums[i]相同的元素，则表示level已经和nums[i]相等的元素交换过，再交换就重复了
     */
    private boolean isRepeat(int[] nums, int level, int i) {
        for (int j = level; j < i; j++) {
            if (nums[j] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
