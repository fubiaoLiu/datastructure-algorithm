package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Related Topics 树 深度优先搜索 数组
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/3
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = null;
        return buildTree1(preorder, inorder, 0, inorder.length - 1, inorder.length, inorderMap);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder,
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

        root.left = buildTree1(preorder, inorder, preStart + 1, rootIn - 1, length - inEnd + rootIn - 1, inorderMap);
        root.right = buildTree1(preorder, inorder, preStart + length - inEnd + rootIn, inEnd, inEnd - rootIn, inorderMap);

        return root;
    }

    /**
     * 第三季练习，思路与buildTree1一致
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, inorder.length - 1, inorder.length);
    }

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *    3
     *   / \
     *  9  20
     *    /  \
     *   15  7
     *
     * 1、0,4,5
     * 2、1,0,1
     *   2,4,3
     */
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
                                int preStart, int inEnd, int length) {
        if (length == 0){
            return null;
        }
        // 3,9
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 1,0
        Integer rootIn = inorderMap.get(rootVal);
        root.left = buildTree(preorder, inorderMap, preStart + 1, rootIn - 1, rootIn - inEnd + length - 1);
        root.right = buildTree(preorder, inorderMap, preStart + rootIn - inEnd + length, inEnd, inEnd - rootIn);
        return root;
    }
}
