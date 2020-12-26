package leetcode.tree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/delete-node-in-a-bst
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/30
 */
public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode rightMin = min(root.right);
                root.val = rightMin.val;
                root.right = deleteMin(root.right);
            }
        }
        return root;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;
        node1.right = node2;

        _450_删除二叉搜索树中的节点 main = new _450_删除二叉搜索树中的节点();
        TreeNode node = main.deleteNode(node3, 3);
        System.out.println(node);
    }
    /*public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (deleteCurrent(root)) {
                return root;
            } else {
                return null;
            }
        } else {
            searchNode(root, key);
        }
        return root;
    }

    private boolean searchNode(TreeNode root, int key) {
        if (root == null) {
            return true;
        }
        if (root.val == key) {
            return deleteCurrent(root);
        } else {
            if (!searchNode(root.left, key)) {
                root.left = null;
            }
            if (!searchNode(root.right, key)) {
                root.right = null;
            }
        }
        return true;
    }

    private boolean deleteCurrent(TreeNode root) {
        boolean flag = false;
        if (root.left != null) {
            root.val = root.left.val;
            flag = deleteCurrent(root.left);
            if (!flag) {
                root.left = null;
                flag = true;
            }
        } else if (root.right != null) {
            root.val = root.right.val;
            flag = deleteCurrent(root.right);
            if (!flag) {
                root.right = null;
                flag = true;
            }
        }
        return flag;
    }

    private void deleteCurrent1(TreeNode root) {
        if (root.left != null) {
            root.val = root.left.val;
            deleteCurrent1(root.left);
        } else if (root.right != null) {
            root.val = root.right.val;
            deleteCurrent1(root.right);
        } else {
            root.val = 0;
        }
    }*/

}
