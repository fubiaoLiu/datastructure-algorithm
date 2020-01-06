package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _783_Test {
    _783_二叉搜索树结点最小距离 minDiffInBST = new _783_二叉搜索树结点最小距离();

    @Test
    public void should_return_0_given_tree0() {
        assertThat(minDiffInBST.minDiffInBST(TreeNodeUtil.tree0())).isEqualTo(0);
    }

    @Test
    public void should_return_0_given_tree1() {
        assertThat(minDiffInBST.minDiffInBST(TreeNodeUtil.tree1())).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree4() {
        assertThat(minDiffInBST.minDiffInBST(TreeNodeUtil.tree4())).isEqualTo(1);
    }

    @Test
    public void should_return_10_given_tree11() {
        assertThat(minDiffInBST.minDiffInBST(TreeNodeUtil.tree11())).isEqualTo(10);
    }
}
