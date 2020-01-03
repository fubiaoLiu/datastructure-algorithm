package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。（假设树中没有重复的元素）
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/3
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = null;
        return buildTree(preorder, inorder, 0, inorder.length - 1, inorder.length, inorderMap);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preStart, int inEnd, int length,
                              Map<Integer, Integer> inorderMap) {
        if (length == 0) {
            return null;
        }
        if (inorderMap == null) {
            inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
        }

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int rootIn = inorderMap.get(val);

        root.left = buildTree(preorder, inorder, preStart + 1, rootIn - 1, length - inEnd + rootIn - 1, inorderMap);
        root.right = buildTree(preorder, inorder, preStart + length - inEnd + rootIn, inEnd, inEnd - rootIn, inorderMap);

        return root;
    }
}
