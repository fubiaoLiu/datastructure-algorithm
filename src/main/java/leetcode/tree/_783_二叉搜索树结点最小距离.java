package leetcode.tree;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * <p>
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
 */
public class _783_二叉搜索树结点最小距离 {
    private Integer minDiff;
    private TreeNode preNode;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff == null ? 0 : minDiff;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (preNode != null) {
            int tmp = Math.abs(root.val - preNode.val);
            minDiff = minDiff == null ? tmp : Math.min(minDiff, tmp);
        }
        preNode = root;
        inorder(root.right);
    }
}
