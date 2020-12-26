package leetcode.tree;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/2
 */
public class _590_N叉树的后序遍历 {
    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        Node node;
        List<Node> children;
        while (!stack.isEmpty()) {
            node = stack.pop();
            children = node.children;
            if (children != null && !children.isEmpty()) {
                node.children = null;
                stack.push(node);
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
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
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null && !children.isEmpty()) {
            children.forEach(node -> postorder(node, list));
        }
        list.add(root.val);
    }
}
