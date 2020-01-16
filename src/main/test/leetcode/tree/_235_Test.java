package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _235_Test {
    _235_二叉搜索树的最近公共祖先 lowestCommonAncestor = new _235_二叉搜索树的最近公共祖先();

    @Test
    public void should_return_null_given_tree0() {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(5);
        assertThat(lowestCommonAncestor.lowestCommonAncestor(BinarySearchTreeNodeUtil.tree0(), p, q)).isNull();
    }

    @Test
    public void should_return_null_given_tree1() {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(5);
        assertThat(lowestCommonAncestor.lowestCommonAncestor(BinarySearchTreeNodeUtil.tree1(), p, q)).isNull();
    }

    @Test
    public void should_return_30_given_tree12() {
        TreeNode p = new TreeNode(20);
        TreeNode q = new TreeNode(40);
        TreeNode root = lowestCommonAncestor.lowestCommonAncestor(BinarySearchTreeNodeUtil.tree12(), p, q);
        assertThat(root.val).isEqualTo(30);
    }
}
