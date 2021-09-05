package leetcode.backtracking;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * Related Topics 数组 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/combination-sum
 *
 * @author FuBiaoLiu
 * @since 2020/2/5
 */
public class _39_组合总和 {
    private int[] candidates;
    private int len;

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.len = candidates.length;

        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, new ArrayDeque<>(len), target, result);
        return result;
    }

    private void combinationSum(int start, Deque<Integer> selected, int target, List<List<Integer>> result) {
        for (int i = start; i < len; i++) {
            if (target < candidates[i]) {
                return;
            }
            selected.addLast(candidates[i]);
            int surplus = target - candidates[i];
            if (surplus == 0) {
                addResult(selected, result);
            } else {
                combinationSum(i, selected, surplus, result);
            }
            selected.removeLast();
        }
    }

    private void addResult(Deque<Integer> selected, List<List<Integer>> result) {
        result.add(new ArrayList<>(selected));
    }

    // ------------------第三季练习--------------------

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || target == 0) {
            return null;
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> deque, int[] candidates, int minIndex, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(deque));
            return;
        }
        for (int i = minIndex; i < candidates.length; i++) {
            int remain = target - candidates[i];
            if (remain < 0) {
                break;
            }
            deque.offer(candidates[i]);
            dfs(result, deque, candidates, i, remain);
            deque.removeLast();
        }
    }
}
