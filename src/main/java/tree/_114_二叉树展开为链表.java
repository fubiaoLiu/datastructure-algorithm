package tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/2
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        flattenChild(root);
    }

    public TreeNode flattenChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = flattenChild(root.left);
        TreeNode rightLast = flattenChild(root.right);
        if (leftLast != null) {
            if (rightLast != null) {
                leftLast.right = root.right;
                root.right = root.left;
                root.left = null;
            }else{
                root.right = root.left;
                root.left = null;
                return leftLast;
            }
        }
        return rightLast != null ? rightLast : root;
    }
}
