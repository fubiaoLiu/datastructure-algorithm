package leetcode.tree;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 * <p>
 * Related Topics 树 深度优先搜索 递归
 * <p>
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * @author FuBiaoLiu
 * @since 2020/1/6
 */
public class _938_二叉搜索树的范围和 {

    private int sum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val <= L) {
            rangeSumBST(root.right, L, R);
        } else if (root.val >= R) {
            rangeSumBST(root.left, L, R);
        } else {
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
        }
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        return sum;
    }
}
