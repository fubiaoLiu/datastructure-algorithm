package leetcode.tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * <p>
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * Related Topics 树 二分查找
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/6
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
