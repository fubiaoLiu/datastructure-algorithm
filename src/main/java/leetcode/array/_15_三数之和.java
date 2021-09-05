package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
 * 复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * Related Topics 数组 双指针
 * <p>
 * https://leetcode-cn.com/problems/3sum
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 14:29
 **/
public class _15_三数之和 {
    /**
     * ①②两处的去重只保留一处即可
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        // l表示左边的元素，r表示右边的元素，m表示中间的元素
        int lMax = nums.length - 3;
        for (int l = 0; l <= lMax; l++) {
            // ①去重
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    while (m < r && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while (m < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    m++;
                    r--;
                } else if (sum < 0) {
                    m++;
                } else {
                    r--;
                }
            }
            // ②去重
            /*while (l <= lMax && nums[l] == nums[l + 1]) {
                l++;
            }*/
        }
        return result;
    }

    /**
     * 未通过测试，漏掉了一部分情况
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            for (int i = l + 1; i < r; i++) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    // 跳过相同的值（去重）
                    while (i < r && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                } else if (sum > 0) {
                    r--;
                    break;
                }
            }
            l++;
        }
        return result;
    }
}
