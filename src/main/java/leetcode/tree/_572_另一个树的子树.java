package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
 * 做它自身的一棵子树。
 * <p>
 *  示例 1:
 * 给定的树 s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *  给定的树 t：
 *    4
 *   / \
 *  1   2
 *  返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 *  示例 2:
 * 给定的树 s：
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 *  给定的树 t：
 *    4
 *   / \
 *  1   2
 *  返回 false。
 * <p>
 *  Related Topics 树
 * <p>
 *  https://leetcode-cn.com/problems/subtree-of-another-tree
 *
 * @author Fubiao.Liu
 * @since 2020/12/10 17:03
 **/
public class _572_另一个树的子树 {
    /**
     * 使用KMP比较
     */
    public boolean isSubtreeKMP(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return contains(postSerialize(s), postSerialize(t));
    }

    /**
     * 使用KMP比较s2是不是s1的子串
     */
    private boolean contains(String s1, String s2) {
        // TODO
        return false;
    }

    /**
     * 使用Java字符串自带的contains方法
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return postSerialize(s).contains(postSerialize(t));
    }

    /**
     * 后序遍历序列化
     */
    public String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root.left, sb);
        postSerialize(root.right, sb);
        sb.append(root.val).append("!");
        return sb.toString();
    }

    /**
     * 后序遍历序列化
     */
    private void postSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#!");
            return;
        }
        postSerialize(node.left, sb);
        postSerialize(node.right, sb);
        sb.append(node.val).append("!");
    }

    /**
     * 后序遍历反序列化
     */
    public TreeNode postDeserialize(String serializeString) {
        if (serializeString == null || serializeString.isEmpty()) {
            return null;
        }
        String[] dataArray = serializeString.split("!");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return postDeserialize(dataList);
    }

    private TreeNode postDeserialize(List<String> dataList) {
        if (dataList.isEmpty()) {
            return null;
        }
        int last = dataList.size() - 1;
        String val = dataList.remove(last);
        if ("#".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.right = postDeserialize(dataList);
        root.left = postDeserialize(dataList);
        return root;
    }
}