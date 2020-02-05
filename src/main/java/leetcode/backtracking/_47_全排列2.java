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
 * https://leetcode-cn.com/problems/permutations-ii
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/5
 */
public class _47_全排列2 {
    private int[] nums;
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
}
