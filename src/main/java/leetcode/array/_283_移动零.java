package leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * Related Topics 数组 双指针
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Fubiao.Liu
 * @since 2021/1/8 13:58
 **/
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (l != i) {
                swap(nums, l, i);
            }
            l++;
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
