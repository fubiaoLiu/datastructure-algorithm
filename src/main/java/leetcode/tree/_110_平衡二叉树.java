package leetcode.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
 */
public class _110_平衡二叉树 {
    /**
     * 出参
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return maxHeight1(root) != -1;
    }

    public int maxHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxHeight1(root.left);
        if (left == -1) {
            return -1;
        }
        int right = maxHeight1(root.right);
        if (right == -1 || Math.abs(right - left) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    private boolean isBalanced;

    /**
     * 成员变量
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        isBalanced = true;
        maxHeight2(root);
        return isBalanced;
    }

    public int maxHeight2(TreeNode root) {
        if (!isBalanced || root == null) {
            return 0;
        }
        int left = maxHeight2(root.left);
        int right = maxHeight2(root.right);
        if (isBalanced && Math.abs(right - left) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
