package leetcode.tree;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * 提示：
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 * <p>
 * Related Topics 树 深度优先搜索
 * <p>
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/6
 */
public class _99_恢复二叉搜索树 {
    private TreeNode n1, n2, lastNode;

    public void recoverTree1(TreeNode root) {
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

    /**
     * -------------第三季练习--------------
     */
    private TreeNode first, second, last;

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public void recoverTreeRecursion(TreeNode root) {
        findWrongNodes(root);
        swap(first, second);
    }

    /**
     * Morris
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void recoverTree(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {
                    pred.right = null;
                    find(node);
                    node = node.right;
                }
            } else {
                find(node);
                node = node.right;
            }
        }
        swap(first, second);
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findWrongNodes(root.left);
        find(root);
        findWrongNodes(root.right);
    }

    private void find(TreeNode root) {
        if (last != null && root.val < last.val) {
            if (first == null) {
                first = last;
            }
            second = root;
        }
        last = root;
    }

    private void swap(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
