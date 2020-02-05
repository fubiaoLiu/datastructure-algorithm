package leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * https://leetcode-cn.com/problems/subsets
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/5
 */
public class _78_子集 {
    private int[] nums;
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        this.nums = nums;
        this.len = nums.length;
        this.result = new ArrayList<>();
        subsets(0, new ArrayDeque<>());
        return result;
    }

    private void subsets(int index, Deque<Integer> selected) {
        if (index >= len){
            return;
        }
        if (index == len - 1) {
            addResult(selected);
        }
        subsets(index + 1, selected);
        selected.addLast(nums[index]);
        if (index == len - 1) {
            addResult(selected);
        } else {
            subsets(index + 1, selected);
        }
        selected.removeLast();
    }

    private void addResult(Deque<Integer> selected) {
        result.add(new ArrayList<>(selected));
    }
}
