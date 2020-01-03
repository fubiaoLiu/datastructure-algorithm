package tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/1/3
 */
public class _701_二叉搜索树中的插入操作 {
    /**
     * 递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    /**
     * 迭代（第一版：本地OK，LeetCode超时，不知道为啥...）
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode parent = root;
        while (true) {
            if (parent.val < val) {
                if (parent.right == null) {
                    parent.right = new TreeNode(val);
                    return root;
                } else {
                    parent = parent.right;
                }
            } else {
                if (parent.left == null) {
                    parent.left = new TreeNode(val);
                    return root;
                } else {
                    parent = parent.left;
                }
            }
        }
    }

    /**
     * 迭代（LeetCode上的迭代版本）
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode parent = root, p = root;
        while (p != null) {
            parent = p;
            p = p.val < val ? p.right : p.left;
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }
}
