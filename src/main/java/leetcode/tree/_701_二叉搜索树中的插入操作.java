package leetcode.tree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * <p>
 * 示例 2：
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * <p>
 * 示例 3：
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 * <p>
 * 提示：
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/3
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
