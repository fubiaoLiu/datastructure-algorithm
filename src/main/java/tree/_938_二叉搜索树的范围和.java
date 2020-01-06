package tree;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
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
