package leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的后序遍历
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 *  \
 *   2
 *  /
 * 3
 * 输出: [3,2,1]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Related Topics 栈 树
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/30
 */
public class _145_二叉树的后序遍历 {
    /**
     * 迭代2
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node, preNode = null;
        while (!stack.isEmpty()) {
            node = stack.peek();
            // 当前节点是叶子节点或者前一个遍历的节点是当前节点的子节点
            if (node.isLeaf() ||
                    (preNode != null && (node.left == preNode || node.right == preNode))) {
                list.add(node.val);
                preNode = stack.pop();
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    }

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
