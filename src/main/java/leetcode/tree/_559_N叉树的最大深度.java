package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
 * null,13,null,null,14]
 * 输出：5
 * <p>
 * 提示：
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 104] 之间。
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/2
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
