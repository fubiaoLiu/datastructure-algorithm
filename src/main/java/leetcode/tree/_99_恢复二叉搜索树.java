package leetcode.tree;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/6
 */
public class _99_恢复二叉搜索树 {
    private TreeNode n1, n2, lastNode;

    public void recoverTree(TreeNode root) {
        inorder(root);
        exchange(n1, n2);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (lastNode != null && root.val < lastNode.val) {
            if (n1 == null) {
                n1 = lastNode;
            }
            n2 = root;
        }
        lastNode = root;
        inorder(root.right);
    }

    public void exchange(TreeNode node1, TreeNode node2) {
        if (n1 == null || n2 == null) {
            return;
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

}
