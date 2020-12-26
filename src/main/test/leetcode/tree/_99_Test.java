package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.BinarySearchTreeNodeUtil;
import utils.TreeNodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class _99_Test {
    _99_恢复二叉搜索树 recoverTree = new _99_恢复二叉搜索树();

    @Test
    public void should_return_null_given_tree0() {
        TreeNode root = TreeNodeUtil.tree0();
        recoverTree.recoverTree(root);
        assertThat(root).isNull();
    }

    @Test
    public void should_return_1_given_tree1() {
        TreeNode root = TreeNodeUtil.tree1();
        recoverTree.recoverTree(root);
        assertThat(root.val).isEqualTo(1);
    }
    @Test
    public void should_return_4_given_tree2() {
        TreeNode root = BinarySearchTreeNodeUtil.tree2();
        recoverTree.recoverTree(root);
        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(1);
        assertThat(root.left.right.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(6);
        assertThat(root.right.left.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(7);
    }
    @Test
    public void should_return_4_given_tree3() {
        TreeNode root = BinarySearchTreeNodeUtil.tree3();
        recoverTree.recoverTree(root);
        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(1);
        assertThat(root.left.right.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(6);
        assertThat(root.right.left.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(7);
    }

    @Test
    public void should_return_4_given_tree4() {
        TreeNode root = BinarySearchTreeNodeUtil.tree4();
        recoverTree.recoverTree(root);
        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(1);
        assertThat(root.left.right.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(6);
        assertThat(root.right.left.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(7);
    }
    @Test
    public void should_return_4_given_tree5() {
        TreeNode root = BinarySearchTreeNodeUtil.tree5();
        recoverTree.recoverTree(root);
        assertThat(root.val).isEqualTo(4);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(1);
        assertThat(root.left.right.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(6);
        assertThat(root.right.left.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(7);
    }
}
