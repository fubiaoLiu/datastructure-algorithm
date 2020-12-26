package leetcode.tree;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
 * 列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * <p>
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 * <p>
 * Related Topics 树
 * <p>
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 *
 * @author Fubiao.Liu
 * @since 2020/12/25 8:56
 **/
public class _449_序列化和反序列化二叉搜索树 {
    /**
     * 不包含空节点的信息，以前序遍历方式序列化，反序列化时通过二分搜索方式查找左右子节点
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String serialize = preSerialize(root, "");
        return serialize.substring(0, serialize.length() - 1);
    }

    private String preSerialize(TreeNode root, String str) {
        if (root != null) {
            str += (root.val + ",");
            str = preSerialize(root.left, str);
            str = preSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(",");
        int[] values = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }
        return preDeserialize(values, 0, strings.length);
    }

    /**
     * 5  3  2  4  8  7  9
     * 0,7
     * 1,4
     * 4,7
     * <p>
     * 1  2
     * 0,2
     * <p>
     * 2  1
     * 0,2
     * 1,2
     * 2,2
     */
    private TreeNode preDeserialize(int[] values, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        TreeNode root = new TreeNode(values[begin]);
        int mid = binarySearchMid(values, values[begin], begin + 1, end);
        if (mid != -1) {
            root.left = preDeserialize(values, begin + 1, mid);
            root.right = preDeserialize(values, mid, end);
        }
        return root;
    }

    /**
     * 1,7
     * 1,4
     * 3,4
     * 4,4
     * <p>
     * 1,2
     * 1,1
     * <p>
     * 1,2
     * 2,2
     */
    private int binarySearchMid(int[] values, int target, int begin, int end) {
        if (begin >= end) {
            return -1;
        }
        /**
         * 4 2 3
         * 1
         * 1
         */
        int mid = (begin + end) >> 1;
        if (values[mid] > target) {
            int left = binarySearchMid(values, target, begin, mid);
            return left == -1 ? mid : left;
        }
        int right = binarySearchMid(values, target, mid + 1, end);
        return right == -1 ? mid + 1 : right;
    }
}