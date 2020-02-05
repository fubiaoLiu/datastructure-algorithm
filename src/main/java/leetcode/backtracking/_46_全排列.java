package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/permutations
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/5
 */
public class _46_全排列 {
    private int[] nums;
    private int len;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        this.nums = nums;
        this.len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        permute(0, result);
        return result;
    }

    private void permute(int start, List<List<Integer>> result) {
        if (start == len) {
            setResult(result);
            return;
        }
        for (int i = start; i < len; i++) {
            swap(start, i);
            permute(start + 1, result);
            swap(start, i);
        }
    }

    private void setResult(List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        result.add(list);
    }

    private void swap(int i1, int i2) {
        if (i1 == i2) {
            return;
        }
        int k = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = k;
    }

    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        permute1(nums, new ArrayList<>(), resultList);
        return resultList;
    }

    private void permute1(int[] nums, List<Integer> selected, List<List<Integer>> result) {
        for (int num : nums) {
            if (selected.contains(num)) {
                continue;
            }
            selected.add(num);
            if (selected.size() == nums.length) {
                result.add(new ArrayList<>(selected));
            } else {
                permute1(nums, selected, result);
            }
            selected.remove(selected.size() - 1);
        }
    }
}
