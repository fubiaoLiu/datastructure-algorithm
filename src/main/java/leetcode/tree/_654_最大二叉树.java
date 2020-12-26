package leetcode.tree;

import java.util.Stack;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * <p>
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * <p>
 * 提示：
 * 给定的数组的大小在 [1, 1000] 之间。
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/maximum-binary-tree
 *
 * @author Fubiao.Liu
 * @since 2020/12/9 16:38
 **/
public class _654_最大二叉树 {
    /**
     * 基于栈查找每个元素左边第一个比他大的值的索引和右边第一个比他大的值的索引
     * 这两个值中最小的就是父节点
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return findRoot(nums, 0, nums.length);
    }

    /**
     * 查找[li,ri)范围内的最大值（根节点）
     */
    private TreeNode findRoot(int[] nums, int li, int ri) {
        if (li >= ri){
            return null;
        }
        // 找出[l, r)范围内最大值的索引
        int maxIds = li;
        for (int i = li + 1; i < ri; i++) {
            if (nums[i] > nums[maxIds]) {
                maxIds = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIds]);
        root.left = findRoot(nums, li, maxIds);
        root.right = findRoot(nums, maxIds + 1, ri);
        return root;
    }

    /**
     * 基于栈查找每个元素左边第一个比他大的值的索引和右边第一个比他大的值的索引
     * 这两个值中最小的就是父节点
     */
    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] lis = new int[nums.length];
        int[] ris = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            lis[i] = -1;
            ris[i] = -1;
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] parentIds = new int[lis.length];
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                parentIds[i] = -1;
            } else if (lis[i] == -1) {
                parentIds[i] = ris[i];
            } else if (ris[i] == -1) {
                parentIds[i] = lis[i];
            } else {
                parentIds[i] = nums[lis[i]] > nums[ris[i]] ? ris[i] : lis[i];
            }
        }
        return parentIds;
    }
}