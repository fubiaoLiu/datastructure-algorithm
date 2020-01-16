package leetcode.tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
 */
public class _230_二叉搜索树中第K小的元素 {
    private int count;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return val;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (count == 0) {
            return;
        }
        count--;
        val = root.val;
        inorder(root.right);
    }
}
