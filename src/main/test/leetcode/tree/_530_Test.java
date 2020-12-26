package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.TreeNodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class _530_Test {
    _530_二叉搜索树的最小绝对差 minimumDifference = new _530_二叉搜索树的最小绝对差();

    @Test
    public void should_return_0_given_tree0() {
        assertThat(minimumDifference.getMinimumDifference1(TreeNodeUtil.tree0())).isEqualTo(0);
        assertThat(minimumDifference.getMinimumDifference2(TreeNodeUtil.tree0())).isEqualTo(0);
    }

    @Test
    public void should_return_0_given_tree1() {
        assertThat(minimumDifference.getMinimumDifference1(TreeNodeUtil.tree1())).isEqualTo(0);
        assertThat(minimumDifference.getMinimumDifference2(TreeNodeUtil.tree1())).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree4() {
        assertThat(minimumDifference.getMinimumDifference1(TreeNodeUtil.tree4())).isEqualTo(1);
        assertThat(minimumDifference.getMinimumDifference2(TreeNodeUtil.tree4())).isEqualTo(1);
    }

    @Test
    public void should_return_10_given_tree11() {
        assertThat(minimumDifference.getMinimumDifference1(TreeNodeUtil.tree11())).isEqualTo(10);
        assertThat(minimumDifference.getMinimumDifference2(TreeNodeUtil.tree11())).isEqualTo(10);
    }
}
