package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 示例：
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * <p>
 * 提示：
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author FuBiaoLiu
 * @since 2020/1/3
 */
public class _889_根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost1(int[] pre, int[] post) {
        Map<Integer, Integer> postIndexMap = null;
        return buildTree(pre, post, 0, post.length - 1, post.length, postIndexMap);
    }

    public TreeNode buildTree(int[] pre, int[] post, int preStart, int postEnd, int length, Map<Integer, Integer> postIndexMap) {
        if (length == 0) {
            return null;
        }
        if (postIndexMap == null) {
            postIndexMap = new HashMap<>();
            for (int i = 0; i < post.length; i++) {
                postIndexMap.put(post[i], i);
            }
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (length != 1) {
        /*if (length == 1) {
            return root;
        } else if (pre[preStart + 1] == post[postEnd - length + 1]
                && pre[preStart + length - 1] == post[postEnd - 1]) {
            root.left = new TreeNode(pre[preStart + 1]);
            if (length == 3) {
                root.right = new TreeNode(pre[preStart + 2]);
            }
        } else {*/
            int leftPreIndex = preStart + 1;
            int leftPostIndex = postIndexMap.get(pre[leftPreIndex]);
            int leftLength = length - postEnd + leftPostIndex;
            // 递归设置左右叶子节点
            root.left = buildTree(pre, post, leftPreIndex, leftPostIndex, leftLength, postIndexMap);
            root.right = buildTree(pre, post, leftPreIndex + leftLength, postEnd - 1, postEnd - leftPostIndex - 1, postIndexMap);
        }
        return root;
    }

    /**
     * 优化版本
     *
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost2(int[] pre, int[] post) {
        Map<Integer, Integer> postIndexMap = null;
        return buildTree(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public TreeNode buildTree(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftPreStart = preStart + 1;
        int leftPostEnd = postStart;
        for (; leftPostEnd <= postEnd; leftPostEnd++) {
            if (post[leftPostEnd] == pre[leftPreStart]) {
                break;
            }
        }
        int leftPreEnd = leftPreStart + leftPostEnd - postStart;

        // 递归设置左右叶子节点
        root.left = buildTree(pre, post, leftPreStart, leftPreEnd, postStart, leftPostEnd);
        root.right = buildTree(pre, post, leftPreEnd + 1, preEnd, leftPostEnd + 1, postEnd - 1);
        return root;
    }
}
