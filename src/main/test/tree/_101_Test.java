package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _101_Test {
    @Test
    public void should_return_true_given_tree0() {
        _101_对称二叉树 symmetric = new _101_对称二叉树();
        assertThat(symmetric.isSymmetric1(TreeNodeUtil.tree0())).isTrue();
        assertThat(symmetric.isSymmetric2(TreeNodeUtil.tree0())).isTrue();
    }

    @Test
    public void should_return_true_given_tree1() {
        _101_对称二叉树 symmetric = new _101_对称二叉树();
        assertThat(symmetric.isSymmetric1(TreeNodeUtil.tree1())).isTrue();
        assertThat(symmetric.isSymmetric2(TreeNodeUtil.tree1())).isTrue();
    }

    @Test
    public void should_return_false_given_tree5() {
        _101_对称二叉树 symmetric = new _101_对称二叉树();
        assertThat(symmetric.isSymmetric1(TreeNodeUtil.tree5())).isFalse();
        assertThat(symmetric.isSymmetric2(TreeNodeUtil.tree5())).isFalse();
    }

    @Test
    public void should_return_true_given_tree10() {
        _101_对称二叉树 symmetric = new _101_对称二叉树();
        assertThat(symmetric.isSymmetric1(TreeNodeUtil.tree10())).isTrue();
        assertThat(symmetric.isSymmetric2(TreeNodeUtil.tree10())).isTrue();
    }
}
