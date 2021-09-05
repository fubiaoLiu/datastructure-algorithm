package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * Related Topics 数组 哈希表
 * <p>
 * https://leetcode-cn.com/problems/two-sum
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 14:17
 **/
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer first = map.get(target - nums[i]);
            if (first != null) {
                return new int[]{first, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
