package leetcode.tree;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树(BST)子树，其中最大指的是子树节点数最多的。
 * <p>
 * 注意：子树必须包含其所有后代
 * <p>
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 *
 * @author Fubiao.Liu
 * @since 2020/12/20
 */
public class _333_最大BST子树 {
    public int largestBSTSubtree(TreeNode root) {
        return root == null ? 0 : getLargestBSTInfo(root).size;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     */
    private Info getLargestBSTInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左子树的最大BST子树信息
        Info lBst = getLargestBSTInfo(root.left);
        // 右子树的最大BST子树信息
        Info rBst = getLargestBSTInfo(root.right);

        /*
        有4种情况，以root为根节点的二叉树就是一棵BST，最大BST子树就是其本身
        ① li != null && ri != null
        && li.root == root.left && root.val > li.max
        && ri.root == root.right && root.val < ri.min

        ② li != null && ri == null
        && li.root == root.left && root.val > li.max

        ③ li == null && ri != null
        && ri.root == root.right && root.val < ri.min

        ④ li == null && ri == null
         */
        int leftBstSize = -1, rightBstSize = -1, max = root.val, min = root.val;
        if (lBst == null) {
            leftBstSize = 0;
        } else if (lBst.root == root.left && lBst.max < root.val) {
            leftBstSize = lBst.size;
            min = lBst.min;
        }
        if (rBst == null) {
            rightBstSize = 0;
        } else if (rBst.root == root.right && rBst.min > root.val) {
            rightBstSize = rBst.size;
            max = rBst.max;
        }
        // 以root为根节点的二叉树并不是BST
        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, max, min, leftBstSize + rightBstSize + 1);
        }
        // 返回最大BST子树的节点数量较多的那个Info
        if (lBst != null && rBst != null) {
            return lBst.size > rBst.size ? lBst : rBst;
        }

        // 返回li、ri中不为null的那个Info
        return lBst != null ? lBst : rBst;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)
     */
    private Info getLargestBSTInfo1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左子树的最大BST子树信息
        Info lBst = getLargestBSTInfo(root.left);
        // 右子树的最大BST子树信息
        Info rBst = getLargestBSTInfo(root.right);

        /*
        有4种情况，以root为根节点的二叉树就是一棵BST，最大BST子树就是其本身
        ① li != null && ri != null
        && li.root == root.left && root.val > li.max
        && ri.root == root.right && root.val < ri.min

        ② li != null && ri == null
        && li.root == root.left && root.val > li.max

        ③ li == null && ri != null
        && ri.root == root.right && root.val < ri.min

        ④ li == null && ri == null
         */
        if (lBst == null && rBst == null) {
            return new Info(root, root.val, root.val, 1);
        }
        if (lBst != null && rBst != null) {
            if (lBst.root == root.left && lBst.max < root.val
                    && rBst.root == root.right && rBst.min > root.val) {
                return new Info(root, rBst.max, lBst.min, lBst.size + rBst.size + 1);
            }
            return lBst.size > rBst.size ? lBst : rBst;
        }
        if (rBst != null) {
            if (rBst.root == root.right && rBst.min > root.val) {
                return new Info(root, rBst.max, root.val, rBst.size + 1);
            }
            return rBst;
        }
        if (lBst.root == root.left && lBst.max < root.val) {
            return new Info(root, root.val, lBst.min, lBst.size + 1);
        }
        return lBst;
    }

    private static class Info {
        TreeNode root;
        int max;
        int min;
        int size;

        Info(TreeNode root, int max, int min, int size) {
            this.root = root;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
}
