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
 * Related Topics 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/permutations
 *
 * @author FuBiaoLiu
 * @since 2020/2/5
 */
public class _46_全排列 {
    private int[] nums;
    private int len;

    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        this.nums = nums;
        this.len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        permute2(0, result);
        return result;
    }

    private void permute2(int start, List<List<Integer>> result) {
        if (start == len) {
            setResult(result);
            return;
        }
        for (int i = start; i < len; i++) {
            swap(start, i);
            permute2(start + 1, result);
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

    //--------------第三季练习--------------

    /**
     * 用数组记录使用过的元素，对应permute1
     */
    public List<List<Integer>> permute3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, result, array, used);
        return result;
    }

    private void dfs(int[] nums, int level, List<List<Integer>> result, int[] array, boolean[] used) {
        if (level == nums.length) {
            ArrayList<Integer> plan = new ArrayList<>();
            for (int num : array) {
                plan.add(num);
            }
            result.add(plan);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            array[level] = nums[i];
            used[i] = true;
            dfs(nums, level + 1, result, array, used);
            used[i] = false;
        }
    }

    /**
     * 每个元素和其他元素交换一次，对应permute2
     */
    public List<List<Integer>> permute(int[] nums) {
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
}
