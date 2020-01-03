package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * <p>
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/3
 */
public class _530_二叉搜索树的最小绝对差 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int minDiff = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (minDiff == -1) {
                minDiff = list.get(i + 1) - list.get(i);
            } else {
                minDiff = Math.min(minDiff, list.get(i + 1) - list.get(i));
            }
        }
        return minDiff;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
