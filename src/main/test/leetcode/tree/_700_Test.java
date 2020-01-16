package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _700_Test {
    _700_二叉搜索树中的搜索 searchBST = new _700_二叉搜索树中的搜索();

    @Test
    public void should_return_null_given_tree0_search_5() {
        assertThat(searchBST.searchBST(TreeNodeUtil.tree0(), 5)).isNull();
        assertThat(searchBST.searchBST1(TreeNodeUtil.tree0(), 5)).isNull();
    }

    @Test
    public void should_return_null_given_tree1_search_5() {
        assertThat(searchBST.searchBST(TreeNodeUtil.tree1(), 5)).isNull();
        assertThat(searchBST.searchBST1(TreeNodeUtil.tree1(), 5)).isNull();
    }

    @Test
    public void should_return_1_given_tree1_search_1() {
        assertThat(searchBST.searchBST(TreeNodeUtil.tree1(), 1).val).isEqualTo(1);
        assertThat(searchBST.searchBST1(TreeNodeUtil.tree1(), 1).val).isEqualTo(1);
    }

    @Test
    public void should_return_null_given_tree4_search_5() {
        assertThat(searchBST.searchBST(TreeNodeUtil.tree4(), 5)).isNull();
        assertThat(searchBST.searchBST1(TreeNodeUtil.tree4(), 5)).isNull();
    }

    @Test
    public void should_return_3_4_given_tree4_search_3() {
        TreeNode root = searchBST.searchBST(TreeNodeUtil.tree4(), 3);
        assertThat(root.val).isEqualTo(3);
        assertThat(root.right.val).isEqualTo(4);

        TreeNode root1 = searchBST.searchBST(TreeNodeUtil.tree4(), 3);
        assertThat(root1.val).isEqualTo(3);
        assertThat(root1.right.val).isEqualTo(4);
    }
}
