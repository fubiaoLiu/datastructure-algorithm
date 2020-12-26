package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.TreeNodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class _114_Test {
    @Test
    public void should_flatten_given_tree0() {
        _114_二叉树展开为链表 flatten = new _114_二叉树展开为链表();
        TreeNode root = TreeNodeUtil.tree0();
        flatten.flatten(root);
        assertThat(root).isNull();
    }

    @Test
    public void should_flatten_given_tree1() {
        _114_二叉树展开为链表 flatten = new _114_二叉树展开为链表();
        TreeNode root = TreeNodeUtil.tree1();
        flatten.flatten(root);

        assertThat(root.left).isNull();
        assertThat(root.right).isNull();
    }

    @Test
    public void should_flatten_given_tree5(){
        _114_二叉树展开为链表 flatten = new _114_二叉树展开为链表();
        TreeNode root = TreeNodeUtil.tree5();
        flatten.flatten(root);

        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.right.val).isEqualTo(3);
        assertThat(root.right.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.right.val).isEqualTo(5);
    }
}
