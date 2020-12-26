package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
public class _449_序列化和反序列化二叉搜索树1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return root == null ? null : postSerialize(root, "");
    }

    private String postSerialize(TreeNode root, String str) {
        if (root != null) {
            str = postSerialize(root.left, str);
            str = postSerialize(root.right, str);
            str += (root.val + ",");
        } else {
            str += "#,";
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(",");
        List<String> values = new LinkedList<>(Arrays.asList(strings));
        return postDeserialize(values);
    }

    private TreeNode postDeserialize(List<String> values) {
        String last = values.remove(values.size() - 1);
        if ("#".equals(last)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = postDeserialize(values);
        root.left = postDeserialize(values);
        return root;
    }
}