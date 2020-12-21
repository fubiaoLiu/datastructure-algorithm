package leetcode.tree;

public class _98_验证二叉搜索树 {
    private long last = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (last >= root.val) {
            return false;
        }
        last = root.val;
        return isValidBST(root.right);
    }
}
