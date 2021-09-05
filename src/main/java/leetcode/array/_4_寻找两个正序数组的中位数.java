package leetcode.array;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * Related Topics 数组 二分查找 分治算法
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author Fubiao.Liu
 * @since 2021/5/7 15:03
 **/
public class _4_寻找两个正序数组的中位数 {
    /**
     * 计算中位数所在索引，然后找到对应的值（代码简化）
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength >> 1;
        int mid2 = -1;
        int num = 1;
        if (totalLength % 2 == 0) {
            mid2 = mid - 1;
            num++;
        }
        int l = 0, r = 0, index = 0, total = 0;
        while (index <= mid) {
            int current = (l >= nums1.length) ? nums2[r++] :
                    ((r >= nums2.length) ? nums1[l++] :
                            (nums1[l] < nums2[r] ? nums1[l++] : nums2[r++]));
            if (index == mid2 || index == mid) {
                total += current;
            }
            index++;
        }
        return (total * 1.0) / num;
    }

    /**
     * 计算中位数所在索引，然后找到对应的值
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength >> 1;
        int mid2 = -1;
        int num = 1;
        if (totalLength % 2 == 0) {
            mid2 = mid - 1;
            num++;
        }
        int l = 0, r = 0, index = 0, total = 0;
        while (l < nums1.length && r < nums2.length && index <= mid) {
            int current = nums1[l] < nums2[r] ? nums1[l++] : nums2[r++];
            if (index == mid2 || index == mid) {
                total += current;
            }
            index++;
        }

        if (index <= mid) {
            while (l < nums1.length && index <= mid) {
                int current = nums1[l++];
                if (index == mid2 || index == mid) {
                    total += current;
                }
                index++;
            }
            while (r < nums2.length && index <= mid) {
                int current = nums2[r++];
                if (index == mid2 || index == mid) {
                    total += current;
                }
                index++;
            }
        }
        return (total * 1.0) / num;
    }
}
