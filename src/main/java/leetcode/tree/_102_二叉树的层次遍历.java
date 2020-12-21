package leetcode.tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/30
 */
public class _102_二叉树的层次遍历 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        int currentLevelNum = 0, nextLevelNum = 0;
        queue.add(root);
        currentLevelNum++;
        TreeNode node;
        List<Integer> levelResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            node = queue.remove();
            levelResult.add(node.val);
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
                result.add(levelResult);
                levelResult = new ArrayList<>();
            }
        }
        return result;
    }

    /**
     * 第三季练习(与1思路一致，代码略有差异)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (--levelCount == 0) {
                result.add(list);
                list = new ArrayList<>();
                levelCount = queue.size();
            }
        }
        return result;
    }
}
