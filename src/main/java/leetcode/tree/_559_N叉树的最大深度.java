package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/2
 */
public class _559_N叉树的最大深度 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize, depth = 0;
        Node node;
        List<Node> children;
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();
                children = node.children;
                if (children != null && !children.isEmpty()) {
                    children.forEach(child -> queue.offer(child));
                }
            }
            depth++;

        }

        return depth;
    }


    private int maxDepth;

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth2(Node root) {
        maxDepth(root, 1);

        return maxDepth;
    }

    public void maxDepth(Node root, int depth) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null && !children.isEmpty()) {
            children.forEach(child -> maxDepth(child, depth + 1));
        } else {
            maxDepth = Math.max(maxDepth, depth);
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth3(Node root) {
        if (root == null) {
            return 0;
        }
        int dept = 0;
        List<Node> children = root.children;
        if (children != null && !children.isEmpty()) {
            for (int i = 0; i < children.size(); i++) {
                dept = Math.max(dept, maxDepth3(root.children.get(i)));
            }
        }

        return dept + 1;
    }
}
