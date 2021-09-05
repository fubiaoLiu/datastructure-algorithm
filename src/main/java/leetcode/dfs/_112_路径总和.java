package leetcode.dfs;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * <p>
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * Related Topics 树 深度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author Fubiao.Liu
 * @since 2021/1/6 17:31
 **/
public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        sum -= root.val;
        if (root.left != null && dfs(root.left, sum)) {
            return true;
        }
        return root.right != null && dfs(root.right, sum);
    }
}
