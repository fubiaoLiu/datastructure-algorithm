package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.BinarySearchTreeNodeUtil;
import utils.TreeNodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class _110_Test {
    _110_平衡二叉树 bst = new _110_平衡二叉树();

    @Test
    public void should_return_true_given_tree0() {
        assertThat(bst.isBalanced1(BinarySearchTreeNodeUtil.tree0())).isTrue();
    }
    @Test
    public void should_return_true_given_tree1() {
        assertThat(bst.isBalanced1(BinarySearchTreeNodeUtil.tree1())).isTrue();
    }
    @Test
    public void should_return_true_given_tree12() {
        assertThat(bst.isBalanced1(BinarySearchTreeNodeUtil.tree12())).isTrue();
    }
    @Test
    public void should_return_false_given_tree5() {
        assertThat(bst.isBalanced1(TreeNodeUtil.tree5())).isFalse();
    }
}
