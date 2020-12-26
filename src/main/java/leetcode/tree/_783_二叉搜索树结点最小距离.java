package leetcode.tree;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * <p>
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *          4
 *        /   \
 *      2      6
 *     / \
 *    1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * <p>
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 相同
 * <p>
 * Related Topics 树 递归
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/6
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
