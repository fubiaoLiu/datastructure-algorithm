package leetcode.tree;

/**
 * @description: 树节点
 * @author: FuBiaoLiu
 * @date: 2019/12/30
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public boolean hasChild() {
        return left != null || right != null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}