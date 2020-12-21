package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _106_Test {
    @Test
    public void should_return_null_given_empry() {
        _106_从中序与后序遍历序列构造二叉树 buildTree = new _106_从中序与后序遍历序列构造二叉树();
        int[] inorder = new int[]{};
        int[] postorder = new int[]{};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        assertThat(root).isNull();
    }

    @Test
    public void should_return_1_given_1() {
        _106_从中序与后序遍历序列构造二叉树 buildTree = new _106_从中序与后序遍历序列构造二叉树();
        int[] inorder = new int[]{3};
        int[] postorder = new int[]{3};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        assertThat(root.val).isEqualTo(3);
    }

    @Test
    public void should_return_not_empty_given_5() {
        _106_从中序与后序遍历序列构造二叉树 buildTree = new _106_从中序与后序遍历序列构造二叉树();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(9);
        assertThat(root.right.val).isEqualTo(20);
        assertThat(root.right.left.val).isEqualTo(15);
        assertThat(root.right.right.val).isEqualTo(7);
    }

    @Test
    public void should_return_not_empty_given_6() {
        _106_从中序与后序遍历序列构造二叉树 buildTree = new _106_从中序与后序遍历序列构造二叉树();
        int[] inorder = new int[]{6, 2, 1, 3, 4, 5};
        int[] postorder = new int[]{6, 2, 5, 4, 3, 1};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(6);
        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.val).isEqualTo(5);
    }
}
