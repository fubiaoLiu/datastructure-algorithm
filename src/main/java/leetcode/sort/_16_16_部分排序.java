package leetcode.sort;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
 * 序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * <p>
 * 提示：
 * 0 <= len(array) <= 1000000
 * <p>
 * Related Topics 排序 数组
 * <p>
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 *
 * @author Fubiao.Liu
 * @since 2020/11/30 17:24
 **/
public class _16_16_部分排序 {
    public int[] subSort(int[] nums) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int max = nums[0];
        int r = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }
        }
        int min = nums[nums.length - 1];
        int l = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                l = i;
            }
        }
        return new int[]{l, r};
    }
}