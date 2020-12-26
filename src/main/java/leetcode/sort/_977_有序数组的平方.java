package leetcode.sort;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * Related Topics 数组 双指针
 * <p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * @author Fubiao.Liu
 * @since 2020/11/30 16:51
 **/
public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int i = nums.length - 1;
        while (l <= r) {
            int lSquares = nums[l] * nums[l];
            int rSquares = nums[r] * nums[r];
            if (lSquares > rSquares) {
                result[i--] = lSquares;
                l++;
            } else {
                result[i--] = rSquares;
                r--;
            }

        }
        return result;
    }
}