package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return buildTree1(inorderList, postorder);
    }

    /**
     * 第一版
     *
     * @param inorder   中序子数组
     * @param postorder 后序子数组
     * @return
     */
    public TreeNode buildTree1(List<Integer> inorder, int[] postorder) {
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

            root.left = buildTree1(inorderLeft, postorderLeft);
        }
        if (!inorderRight.isEmpty()) {
            int[] postorderRight = new int[inorderRight.size()];
            for (int i = 0; i < inorderRight.size(); i++) {
                postorderRight[i] = postorder[inorderLeft.size() + i];
            }

            root.right = buildTree1(inorderRight, postorderRight);
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
        return buildTree2(inorder, postorder, 0, postorder.length, postorder.length);
    }

    /**
     * @param inorder   中序数组
     * @param postorder 后序数组
     * @param inStart   中序开始节点
     * @param postEnd   后序结束节点
     * @param length    长度
     * @return
     */
    public static TreeNode buildTree2(int[] inorder, int[] postorder, int inStart, int postEnd, int length) {
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
                treeNode.left = buildTree2(inorder, postorder, inStart, postEnd - length + i, i);
                treeNode.right = buildTree2(inorder, postorder, inStart + i + 1, postEnd - 1, length - 1 - i);
                return treeNode;
            }
        }
        return null;
    }

    /**
     * 第三季练习
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, inorderMap, postorder.length - 1, inorder.length - 1, inorder.length);
    }

    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap,
                               int postStart, int inEnd, int length) {
        if (length == 0) {
            return null;
        }
        int rootVal = postorder[postStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIn = inorderMap.get(rootVal);
        root.right = buildTree(postorder, inorderMap, postStart - 1, inEnd, inEnd - rootIn);
        root.left = buildTree(postorder, inorderMap, postStart - inEnd + rootIn - 1, rootIn - 1, length - inEnd + rootIn - 1);

        return root;
    }

}
