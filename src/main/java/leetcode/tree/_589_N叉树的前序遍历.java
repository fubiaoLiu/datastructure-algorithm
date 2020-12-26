package leetcode.tree;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/2
 */
public class _589_N叉树的前序遍历 {
    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
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
            list.add(node.val);
            children = node.children;
            if (children != null && !children.isEmpty()) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
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
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children != null && !children.isEmpty()) {
            int size = children.size();
            for (int i = 0; i < size; i++) {
                preorder(children.get(i), list);
            }
        }
    }
}
