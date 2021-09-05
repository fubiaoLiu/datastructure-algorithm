package leetcode.dfs;

import leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * Related Topics 树 深度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author Fubiao.Liu
 * @since 2021/1/7 17:02
 **/
public class _113_路径总和2 {
    /**
     * 结果集大小不确定，使用LinkedList优于ArrayList
     * 存储已选节点的数据结构，需要往尾部添加删除元素，所以可以考虑双端队列/栈
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        dfs(result, new LinkedList<>(), root, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> deque, TreeNode root, int sum) {
        deque.offer(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(deque));
        } else {
            sum -= root.val;
            if (root.left != null) {
                dfs(result, deque, root.left, sum);
            }
            if (root.right != null) {
                dfs(result, deque, root.right, sum);
            }
        }
        deque.removeLast();
    }
}
