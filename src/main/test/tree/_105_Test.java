package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _105_Test {
    @Test
    public void should_return_null_given_empry() {
        _105_从前序与中序遍历序列构造二叉树 buildTree = new _105_从前序与中序遍历序列构造二叉树();
        int[] preorder = new int[]{};
        int[] inorder = new int[]{};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        assertThat(root).isNull();
    }

    @Test
    public void should_return_1_given_1() {
        _105_从前序与中序遍历序列构造二叉树 buildTree = new _105_从前序与中序遍历序列构造二叉树();
        int[] preorder = new int[]{3};
        int[] inorder = new int[]{3};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        assertThat(root.val).isEqualTo(3);
    }

    @Test
    public void should_return_not_empty_given_5() {
        _105_从前序与中序遍历序列构造二叉树 buildTree = new _105_从前序与中序遍历序列构造二叉树();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(9);
        assertThat(root.right.val).isEqualTo(20);
        assertThat(root.right.left.val).isEqualTo(15);
        assertThat(root.right.right.val).isEqualTo(7);
    }

    @Test
    public void should_return_not_empty_given_6() {
        _105_从前序与中序遍历序列构造二叉树 buildTree = new _105_从前序与中序遍历序列构造二叉树();
        int[] preorder = new int[]{1, 2,6, 3, 4, 5};
        int[] inorder = new int[]{6, 2, 1, 3, 4, 5};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(6);
        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.val).isEqualTo(5);
    }
}
