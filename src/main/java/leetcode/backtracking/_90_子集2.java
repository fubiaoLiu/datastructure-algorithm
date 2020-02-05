package leetcode.backtracking;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * https://leetcode-cn.com/problems/subsets-ii
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/5
 */
public class _90_子集2 {
    private int[] nums;
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        this.result = new ArrayList<>();
        dfs(0, new boolean[len], new ArrayDeque<>());
        return result;
    }

    private void dfs(int index, boolean[] used, Deque<Integer> stack) {
        result.add(new ArrayList<>(stack));
        int pre = nums[0] - 1;
        for (int i = index; i < len; i++) {
            int num = nums[i];
            if (used[i] || (pre == num && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            stack.push(num);
            dfs(i + 1, used, stack);
            used[i] = false;
            stack.poll();
            pre = num;
        }
    }
}
