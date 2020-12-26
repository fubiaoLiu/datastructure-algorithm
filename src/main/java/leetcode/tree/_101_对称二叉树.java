package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/3
 */
public class _101_对称二叉树 {
    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        TreeNode node1;
        TreeNode node2;
        while (!queue.isEmpty()) {
            node1 = queue.poll();
            node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            } else {
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
        }
        return true;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
