package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * 提示：
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * <p>
 * Related Topics 栈 树 设计
 * <p>
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/6
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
