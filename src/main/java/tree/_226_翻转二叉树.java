package tree;

/**
 * 翻转一棵二叉树。
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/30
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
