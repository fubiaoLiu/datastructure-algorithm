package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * <p>
 * 示例：
 * 输入：
 *    1
 *     \
 *      3
 *     /
 *    2
 * 输出：1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author FuBiaoLiu
 * @since 2020/1/3
 */
public class _530_二叉搜索树的最小绝对差 {
    /**
     * 先中序遍历按顺序记录所有节点，再计算相邻两个数的绝对差取最小值
     *
     * @param root
     * @return
     */
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        Integer minDiff = null;
        int tmp;
        for (int i = 0; i < list.size() - 1; i++) {
            tmp = Math.abs(list.get(i + 1) - list.get(i));
            if (minDiff == null) {
                minDiff = tmp;
            } else {
                minDiff = Math.min(minDiff, tmp);
            }
        }
        return minDiff == null ? 0 : minDiff;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 按中序遍历依次记录前一个节点的值，然后计算当前节点和前一个节点的值。
     *
     * @param root
     * @return
     */
    private TreeNode preNode;
    private Integer minDiff;

    public int getMinimumDifference2(TreeNode root) {
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
