package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _662_Test {
    @Test
    public void should_return_empty_given_tree0() {
        _662_二叉树最大宽度 maxWidth = new _662_二叉树最大宽度();
        assertThat(maxWidth.widthOfBinaryTree1(TreeNodeUtil.tree0())).isEqualTo(0);
        assertThat(maxWidth.widthOfBinaryTree2(TreeNodeUtil.tree0())).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        _662_二叉树最大宽度 maxWidth = new _662_二叉树最大宽度();
        assertThat(maxWidth.widthOfBinaryTree1(TreeNodeUtil.tree1())).isEqualTo(1);
        assertThat(maxWidth.widthOfBinaryTree2(TreeNodeUtil.tree1())).isEqualTo(1);
    }

    @Test
    public void should_return_2_given_tree5() {
        _662_二叉树最大宽度 maxWidth = new _662_二叉树最大宽度();
        assertThat(maxWidth.widthOfBinaryTree1(TreeNodeUtil.tree5())).isEqualTo(2);
        assertThat(maxWidth.widthOfBinaryTree2(TreeNodeUtil.tree5())).isEqualTo(2);
    }

    @Test
    public void should_return_4_given_tree8() {
        _662_二叉树最大宽度 maxWidth = new _662_二叉树最大宽度();
        assertThat(maxWidth.widthOfBinaryTree1(TreeNodeUtil.tree8())).isEqualTo(4);
        assertThat(maxWidth.widthOfBinaryTree2(TreeNodeUtil.tree8())).isEqualTo(4);
    }
    @Test
    public void should_return_8_given_tree9() {
        _662_二叉树最大宽度 maxWidth = new _662_二叉树最大宽度();
        assertThat(maxWidth.widthOfBinaryTree1(TreeNodeUtil.tree9())).isEqualTo(8);
        assertThat(maxWidth.widthOfBinaryTree2(TreeNodeUtil.tree9())).isEqualTo(8);
    }
}
