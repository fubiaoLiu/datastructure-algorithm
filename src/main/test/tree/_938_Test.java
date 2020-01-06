package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _938_Test {
    _938_二叉搜索树的范围和 rangeSumBST = new _938_二叉搜索树的范围和();

    @Test
    public void should_return_0_given_tree0_0_5() {
        assertThat(rangeSumBST.rangeSumBST(TreeNodeUtil.tree0(), 0, 5)).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1_0_5() {
        assertThat(rangeSumBST.rangeSumBST(TreeNodeUtil.tree1(), 0, 5)).isEqualTo(1);
    }

    @Test
    public void should_return_7_given_tree5_3_4() {
        assertThat(rangeSumBST.rangeSumBST(TreeNodeUtil.tree5(), 3, 4)).isEqualTo(7);
    }

    @Test
    public void should_return_220_given_tree12_40_70() {
        assertThat(rangeSumBST.rangeSumBST(BinarySearchTreeNodeUtil.tree12(), 40, 70)).isEqualTo(220);
    }

    @Test
    public void should_return_170_given_tree12_80_100() {
        assertThat(rangeSumBST.rangeSumBST(BinarySearchTreeNodeUtil.tree12(), 80, 100)).isEqualTo(170);
    }

    @Test
    public void should_return_30_given_tree12_0_20() {
        assertThat(rangeSumBST.rangeSumBST(BinarySearchTreeNodeUtil.tree12(), 0, 20)).isEqualTo(30);
    }


}
