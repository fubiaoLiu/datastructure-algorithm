package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _701_Test {
    _701_二叉搜索树中的插入操作 insertIntoBST = new _701_二叉搜索树中的插入操作();

    @Test
    public void should_return_5_given_tree0_insert_5() {
        assertThat(insertIntoBST.insertIntoBST(TreeNodeUtil.tree0(), 5).val).isEqualTo(5);
        assertThat(insertIntoBST.insertIntoBST1(TreeNodeUtil.tree0(), 5).val).isEqualTo(5);
    }

    @Test
    public void should_return_1_5_given_tree1_insert_5() {
        TreeNode root = insertIntoBST.insertIntoBST(TreeNodeUtil.tree1(), 5);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(5);

        TreeNode root1 = insertIntoBST.insertIntoBST(TreeNodeUtil.tree1(), 5);
        assertThat(root1.val).isEqualTo(1);
        assertThat(root1.right.val).isEqualTo(5);
    }

    @Test
    public void should_return_1_23_4_5_given_tree4_insert_5() {
        TreeNode root = insertIntoBST.insertIntoBST(TreeNodeUtil.tree4(), 5);
        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.val).isEqualTo(5);

        TreeNode root1 = insertIntoBST.insertIntoBST(TreeNodeUtil.tree4(), 5);
        assertThat(root1.val).isEqualTo(1);
        assertThat(root1.left.val).isEqualTo(2);
        assertThat(root1.right.val).isEqualTo(3);
        assertThat(root1.right.right.val).isEqualTo(4);
        assertThat(root1.right.right.right.val).isEqualTo(5);
    }

    @Test
    public void should_return_40_2060_1030_5070_given_tree11_insert_25() {
        TreeNode root = insertIntoBST.insertIntoBST(TreeNodeUtil.tree11(), 25);
        assertThat(root.val).isEqualTo(40);
        assertThat(root.left.val).isEqualTo(20);
        assertThat(root.left.left.val).isEqualTo(10);
        assertThat(root.left.right.val).isEqualTo(30);
        assertThat(root.left.right.left.val).isEqualTo(25);
        assertThat(root.right.val).isEqualTo(60);
        assertThat(root.right.left.val).isEqualTo(50);
        assertThat(root.right.right.val).isEqualTo(70);

        TreeNode root1 = insertIntoBST.insertIntoBST(TreeNodeUtil.tree11(), 25);
        assertThat(root1.val).isEqualTo(40);
        assertThat(root1.left.val).isEqualTo(20);
        assertThat(root1.left.left.val).isEqualTo(10);
        assertThat(root1.left.right.val).isEqualTo(30);
        assertThat(root1.left.right.left.val).isEqualTo(25);
        assertThat(root1.right.val).isEqualTo(60);
        assertThat(root1.right.left.val).isEqualTo(50);
        assertThat(root1.right.right.val).isEqualTo(70);
    }
}
