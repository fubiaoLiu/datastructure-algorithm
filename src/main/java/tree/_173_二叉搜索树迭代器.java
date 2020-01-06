package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
 */
public class _173_二叉搜索树迭代器 {
    private Deque<TreeNode> stack = new LinkedList<>();

    public _173_二叉搜索树迭代器(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }


    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        if (stack.isEmpty()) {
            throw new RuntimeException("next is not exist.");
        }
        TreeNode node = stack.pop();
        int val = node.val;
        if ((node = node.right) != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return val;
    }
}
