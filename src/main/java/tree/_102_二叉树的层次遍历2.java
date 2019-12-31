package tree;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/31
 */
public class _102_二叉树的层次遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count;
        TreeNode node;
        List<Integer> levelList;
        while (!queue.isEmpty()){
            count = queue.size();
            levelList = new ArrayList<>(count);
            for (int i = 0;i < count;i++){
                node = queue.poll();
                levelList.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.addFirst(levelList);
        }
        return result;
    }
}
