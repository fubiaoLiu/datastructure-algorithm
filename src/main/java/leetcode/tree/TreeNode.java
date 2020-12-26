package leetcode.tree;

/**
 * 树节点
 *
 * @author FuBiaoLiu
 * @since 2019/12/30
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public boolean hasChild() {
        return left != null || right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
