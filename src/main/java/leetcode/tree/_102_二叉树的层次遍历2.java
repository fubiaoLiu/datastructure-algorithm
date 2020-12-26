package leetcode.tree;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * <p>
 * Related Topics 树 广度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/31
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
