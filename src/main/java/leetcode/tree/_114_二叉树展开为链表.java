package leetcode.tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 *      1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 *  1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * <p>
 *  Related Topics 树 深度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/2
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        flattenChild(root);
    }

    /**
     * 将右子节点拼到左子节点的最末尾节点，然后将左子节点移到右边
     * @param root
     * @return
     */
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
