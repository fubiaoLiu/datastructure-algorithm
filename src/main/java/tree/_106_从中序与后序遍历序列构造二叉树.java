package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/3
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        List<Integer> inorderList = new ArrayList<>(inorder.length);
        for (Integer s : inorder) {
            inorderList.add(s);
        }
        return buildTree(inorderList, postorder);
    }

    /**
     * 第一版
     *
     * @param inorder   中序子数组
     * @param postorder 后序子数组
     * @return
     */
    public TreeNode buildTree(List<Integer> inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        List<Integer> inorderLeft = new ArrayList<>();
        List<Integer> inorderRight = new ArrayList<>();
        boolean rightFlag = false;
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder.get(i) == root.val) {
                rightFlag = true;
            } else {
                if (rightFlag) {
                    inorderRight.add(inorder.get(i));
                } else {
                    inorderLeft.add(inorder.get(i));
                }
            }
        }

        if (!inorderLeft.isEmpty()) {
            int[] postorderLeft = new int[inorderLeft.size()];
            for (int i = 0; i < inorderLeft.size(); i++) {
                postorderLeft[i] = postorder[i];
            }

            root.left = buildTree(inorderLeft, postorderLeft);
        }
        if (!inorderRight.isEmpty()) {
            int[] postorderRight = new int[inorderRight.size()];
            for (int i = 0; i < inorderRight.size(); i++) {
                postorderRight[i] = postorder[inorderLeft.size() + i];
            }

            root.right = buildTree(inorderRight, postorderRight);
        }

        return root;
    }

    /**
     * 优化版本
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length, postorder.length);
    }

    /**
     * @param inorder   中序数组
     * @param postorder 后序数组
     * @param inStart   中序开始节点
     * @param postEnd   后序结束节点
     * @param length    长度
     * @return
     */
    public static TreeNode build(int[] inorder, int[] postorder, int inStart, int postEnd, int length) {
        if (length == 0) {
            return null;
        }
        int root = postorder[postEnd - 1];
        TreeNode treeNode = new TreeNode(root);
        if (length == 1) {
            return treeNode;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (root == inorder[inStart + i]) {
                treeNode.left = build(inorder, postorder, inStart, postEnd - length + i, i);
                treeNode.right = build(inorder, postorder, inStart + i + 1, postEnd - 1, length - 1 - i);
                return treeNode;
            }
        }
        return null;
    }
}
