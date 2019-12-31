package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的后序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/30
 */
public class _145_二叉树的后序遍历 {
    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node, left, right;
        while (!stack.isEmpty()) {
            node = stack.pop();

            if (node.left != null || node.right != null) {
                left = node.left;
                right = node.right;
                node.left = null;
                node.right = null;
                stack.push(node);
                if (right != null) {
                    stack.push(right);
                }
                if (left != null) {
                    stack.push(left);
                }
            } else {
                list.add(node.val);
            }
        }

        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}
