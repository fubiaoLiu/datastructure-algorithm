package leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary leetcode.tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/2
 */
public class _662_二叉树最大宽度 {

    private int maxWidth;
    Map<Integer, Integer> leftNodeMap;

    /**
     * 深度优先搜索
     * 每一层第一个到达的节点记为最左节点，记录对应index。
     * 左子节点的index为父节点的 index*2 ，右子节点的index为父节点的 index*2+1 。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree1(TreeNode root) {
        maxWidth = 0;
        leftNodeMap = new HashMap<>();
        dfs(root, 0, 0);
        return maxWidth;
    }

    public void dfs(TreeNode root, int level, int index) {
        if (root == null) {
            return;
        }
        int left = leftNodeMap.computeIfAbsent(level, v -> index);
        maxWidth = Math.max(maxWidth, index - left + 1);
        dfs(root.left, level + 1, index << 1);
        dfs(root.right, level + 1, (index << 1) + 1);
    }

    /**
     * 层序遍历
     * 每一次取一层的节点数据遍历，第一个为最左节点，最后一个为最右节点，他们的宽度即这一层的宽度。
     * 使用两个队列，一个存储元素，一个存储元素对应的index。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        nodeQueue.add(root);
        indexQueue.add(1);
        TreeNode node;
        int maxWidth = 0, levelSize, index, leftIndex = 0, rightIndex = 0;
        while (!nodeQueue.isEmpty()) {
            levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; i++) {
                node = nodeQueue.remove();
                index = indexQueue.remove();
                if (i == 0) {
                    leftIndex = index;
                }
                if (i == levelSize - 1) {
                    rightIndex = index;
                }
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    indexQueue.add(index << 1);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    indexQueue.add((index << 1) + 1);
                }
            }
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        return maxWidth;
    }
}
