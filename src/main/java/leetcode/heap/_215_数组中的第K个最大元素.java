package leetcode.heap;


import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * Related Topics 堆 分治算法
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 * @author Fubiao.Liu
 * @since 2021/2/5 17:04
 **/
public class _215_数组中的第K个最大元素 {
    /**
     * 小顶堆，代码调整
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }

    /**
     * 小顶堆
     */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() == k) {
                if (heap.peek() >= num) {
                    continue;
                }
                heap.poll();
            }
            heap.offer(num);
        }
        return heap.peek();
    }
}
