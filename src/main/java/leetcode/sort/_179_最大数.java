package leetcode.sort;


import java.util.PriorityQueue;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * Related Topics 排序
 *
 * @author Fubiao.Liu
 * @since 2021/5/14 16:51
 **/
public class _179_最大数 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : nums) {
            heap.offer(String.valueOf(num));
        }
        String res = "";
        while (!heap.isEmpty()) {
            res += heap.poll();
        }
        return '0' == res.charAt(0) ? "0" : res;
    }
}
