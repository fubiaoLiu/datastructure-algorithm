package leetcode.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num[i] 的元素的数量。
 * <p>
 * 示例：
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * Related Topics 排序 树状数组 线段树 二分查找 分治算法
 * <p>
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 *
 * @author Fubiao.Liu
 * @since 2021/2/5 17:30
 **/
public class _315_计算右侧小于当前元素的个数 {
    /**
     * 归并（从大到小排序）
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        merge(nums, 0, nums.length, result, new int[nums.length]);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private int[] merge(int[] nums, int left, int right, int[] result, int[] indexArray) {
        if (right - left == 1) {
            indexArray[0] = left;
            return new int[]{nums[left]};
        }
        int mid = (right + left) >> 1;
        System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
        int[] leftIndexArray = new int[mid - left];
        int[] leftArray = merge(nums, left, mid, result, leftIndexArray);

        int[] rightIndexArray = new int[right - mid];
        int[] rightArray = merge(nums, mid, right, result, rightIndexArray);

        int[] array = new int[right - left];
        int l = 0, r = 0, index = 0;
        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] > rightArray[r]) {
                array[index] = leftArray[l];
                indexArray[index] = leftIndexArray[l];
                result[leftIndexArray[l]] += (rightArray.length - r);
                l++;
            } else {
                array[index] = rightArray[r];
                indexArray[index] = rightIndexArray[r];
                r++;
            }
            index++;
        }
        while (l < leftArray.length){
            array[index] = leftArray[l];
            indexArray[index] = leftIndexArray[l];
            l++;
            index++;
        }
        while (r < rightArray.length){
            array[index] = rightArray[r];
            indexArray[index] = rightIndexArray[r];
            r++;
            index++;
        }

        return array;
    }

    /**
     * 树状结构 + 数组计数（超时）
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] counts = new int[nums.length];
        Node root = new Node(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Node parent = root;
            int currentNum = nums[i];
            Node current = new Node(currentNum, i);
            while (parent != current) {
                if (parent.num < currentNum) {
                    if (parent.right == null) {
                        parent.right = current;
                    }
                    parent = parent.right;
                } else if (parent.num == currentNum) {
                    incrementAll(counts, parent.right);
                    current.left = parent.left;
                    parent = parent.left = current;
                } else {
                    counts[parent.index]++;
                    incrementAll(counts, parent.right);
                    if (parent.left == null) {
                        parent.left = current;
                    }
                    parent = parent.left;
                }
            }
        }
        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }

    /**
     * 右侧所有节点计数+1
     *
     * @param counts 计数数组
     * @param root   右侧根节点
     */
    private void incrementAll(int[] counts, Node root) {
        if (root == null) {
            return;
        }
        counts[root.index]++;
        incrementAll(counts, root.left);
        incrementAll(counts, root.right);
    }

    static class Node {
        int num;
        int index;
        Node left;
        Node right;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
