package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用递归和迭代两种方式计算二叉树的高度
 *
 * @author FuBiaoLiu
 * @since 2019/12/31
 */
public class 计算二叉树的高度 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int calculatedHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int childHeight, leftHeight, rightHeight;
        if (root.left == null) {
            childHeight = calculatedHeight1(root.right);
        } else if (root.right == null) {
            childHeight = calculatedHeight1(root.left);
        } else {
            leftHeight = calculatedHeight1(root.left);
            rightHeight = calculatedHeight1(root.right);
            childHeight = Math.max(leftHeight, rightHeight);
        }
        return childHeight + 1;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int calculatedHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0, currentLevelNum = 0, nextLevelNum = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        currentLevelNum++;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            currentLevelNum--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNum++;
            }
            if (currentLevelNum == 0) {
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                height++;
            }
        }
        return height;
    }
}
