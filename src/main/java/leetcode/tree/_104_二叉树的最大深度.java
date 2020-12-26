package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度 3 。
 * <p>
 * Related Topics 树 深度优先搜索 递归
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/31
 */
public class _104_二叉树的最大深度 {
    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, currentLevelNum = 1, nextLevelNum = 0;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            currentLevelNum--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNum++;
            }
            if (currentLevelNum == 0) {
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                depth++;
            }
        }
        return depth;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /**
     * 第三季练习：迭代(与maxDepth1思路一致)
     *
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 0, level = 0;
        while (!queue.isEmpty()) {
            if (levelCount == 0) {
                levelCount = queue.size();
                level++;
            }
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            levelCount--;
        }
        return level;
    }

}
