package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _889_Test {
    @Test
    public void should_return_null_given_empry() {
        _889_根据前序和后序遍历构造二叉树 buildTree = new _889_根据前序和后序遍历构造二叉树();
        int[] pre = new int[]{};
        int[] post = new int[]{};
        TreeNode root = buildTree.constructFromPrePost1(pre, post);
        assertThat(root).isNull();

        TreeNode root2 = buildTree.constructFromPrePost2(pre, post);
        assertThat(root2).isNull();
    }

    @Test
    public void should_return_1_given_1() {
        _889_根据前序和后序遍历构造二叉树 buildTree = new _889_根据前序和后序遍历构造二叉树();
        int[] preorder = new int[]{3};
        int[] inorder = new int[]{3};
        TreeNode root = buildTree.constructFromPrePost1(preorder, inorder);
        assertThat(root.val).isEqualTo(3);

        TreeNode root2 = buildTree.constructFromPrePost2(preorder, inorder);
        assertThat(root2.val).isEqualTo(3);
    }

    @Test
    public void should_return_not_empty_given_5() {
        _889_根据前序和后序遍历构造二叉树 buildTree = new _889_根据前序和后序遍历构造二叉树();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = buildTree.constructFromPrePost1(preorder, postorder);
        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(9);
        assertThat(root.right.val).isEqualTo(20);
        assertThat(root.right.left.val).isEqualTo(15);
        assertThat(root.right.right.val).isEqualTo(7);

        TreeNode root2 = buildTree.constructFromPrePost2(preorder, postorder);
        assertThat(root2.val).isEqualTo(3);
        assertThat(root2.left.val).isEqualTo(9);
        assertThat(root2.right.val).isEqualTo(20);
        assertThat(root2.right.left.val).isEqualTo(15);
        assertThat(root2.right.right.val).isEqualTo(7);
    }

    @Test
    public void should_return_not_empty_given_6() {
        _889_根据前序和后序遍历构造二叉树 buildTree = new _889_根据前序和后序遍历构造二叉树();
        int[] preorder = new int[]{1, 2, 6, 3, 4, 5};
        int[] postorder = new int[]{6, 2, 5, 4, 3, 1};
        TreeNode root = buildTree.constructFromPrePost1(preorder, postorder);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.left.left.val).isEqualTo(6);
        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.left.val).isEqualTo(4);
        assertThat(root.right.left.left.val).isEqualTo(5);


        TreeNode root2 = buildTree.constructFromPrePost2(preorder, postorder);
        assertThat(root2.val).isEqualTo(1);
        assertThat(root2.left.val).isEqualTo(2);
        assertThat(root2.left.left.val).isEqualTo(6);
        assertThat(root2.right.val).isEqualTo(3);
        assertThat(root2.right.left.val).isEqualTo(4);
        assertThat(root2.right.left.left.val).isEqualTo(5);
    }
}
