package leetcode.dfs;

import leetcode.tree.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中至多出现一次。该路径至少包含一个节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 示例 1：(层序遍历)
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * 提示：
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <p>
 * Related Topics 树 深度优先搜索 递归
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author Fubiao.Liu
 * @since 2021/5/17 9:52
 **/
public class _124_二叉树中的最大路径和 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(root)[0];
    }

    /**
     * @param root 根节点
     * @return 最大路径和
     * int[0]：最大路径和（包含起始节点）不一定是包含当前根节点
     * int[1]：最大路径和（不包含起始节点）一定包含当前根节点
     * int[2]：根节点的值
     */
    private int[] max(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val, root.val};
        }
        int[] result = new int[3];
        if (root.left != null && root.right != null) {
            int[] left = max(root.left);
            int[] right = max(root.right);
            int rootLeft = Math.max(root.val + left[1], root.val);
            int rootRight = Math.max(root.val + right[1], root.val);
            int leftMax = Math.max(left[1], left[2]);
            int rightMax = Math.max(right[1], right[2]);
            result[0] = Math.max((leftMax > 0 ? (rootRight + leftMax) : rootRight), (rightMax > 0 ? (rootLeft + rightMax) : rootLeft));
            result[0] = Math.max(Math.max(result[0], Math.max(left[0], right[0])), root.val);
            result[1] = Math.max(rootLeft, rootRight);
        } else if (root.left != null) {
            int[] left = max(root.left);
            result[1] = Math.max(root.val + left[1], root.val);
            result[0] = Math.max(result[1], left[0]);
        } else {
            int[] right = max(root.right);
            result[1] = Math.max(root.val + right[1], root.val);
            result[0] = Math.max(result[1], right[0]);
        }
        result[2] = root.val;
        return result;
    }
}
