package leetcode.array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * Related Topics 数组 二分查找
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author Fubiao.Liu
 * @since 2021/5/24 14:02
 **/
public class _33_搜索旋转排序数组 {
    /**
     * 二分查找
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        return binarySearch(nums, target, 0, nums.length);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (end - start == 1) {
            return nums[start] == target ? start : -1;
        }
        int mid = (end + start) >> 1;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] < target) {
            if (nums[mid] > target || nums[mid] < nums[start]) {
                return binarySearch(nums, target, start, mid);
            } else {
                return binarySearch(nums, target, mid, end);
            }
        } else {
            if (nums[mid] > nums[start] || nums[mid] < target) {
                return binarySearch(nums, target, mid, end);
            } else {
                return binarySearch(nums, target, start, mid);
            }
        }
    }
}
