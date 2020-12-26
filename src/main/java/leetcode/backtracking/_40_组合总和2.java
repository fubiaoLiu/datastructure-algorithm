package leetcode.backtracking;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * Related Topics 数组 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author FuBiaoLiu
 * @since 2020/2/5
 */
public class _40_组合总和2 {
    private int[] candidates;
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.len = candidates.length;
        this.result = new ArrayList<>();
        dfs(target, new boolean[len], new ArrayDeque<>(), 0);
        return result;
    }

    private void dfs(int target, boolean[] used, Deque<Integer> stack, int index) {
        int pre = candidates[0] - 1;
        for (int i = index; i < len; i++) {
            int candidate = candidates[i];
            if (candidate > target) {
                return;
            } else if (used[i] || (pre == candidate && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            stack.push(candidate);
            int surplus = target - candidate;
            if (surplus == 0) {
                addResult(stack);
            } else {
                dfs(surplus, used, stack, i + 1);
            }
            used[i] = false;
            stack.poll();
            pre = candidate;
        }
    }

    private void addResult(Deque<Integer> selected) {
        result.add(new ArrayList<>(selected));
    }
}
