package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
 * 式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
 * 反序列化为原始的树结构。
 * <p>
 * 示例:
 * 你可以将以下二叉树：
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
 * 个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author Fubiao.Liu
 * @since 2020/12/22
 */
public class _297_二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrderSerialize(root, "");
    }

    private String preOrderSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "Null,";
        } else {
            str += root.val + ",";
            str = preOrderSerialize(root.left, str);
            str = preOrderSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return preOrderDeserialize(dataList);
    }

    private TreeNode preOrderDeserialize(List<String> dataList) {
        if (dataList.isEmpty()) {
            return null;
        }
        String data = dataList.get(0);
        if ("Null".equals(data)) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data));
        dataList.remove(0);
        root.left = preOrderDeserialize(dataList);
        root.right = preOrderDeserialize(dataList);
        return root;
    }
}
