package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _230_Test {
    _230_二叉搜索树中第K小的元素 kthSmallest = new _230_二叉搜索树中第K小的元素();

    @Test
    public void should_return_10_given_tree12_1() {
        assertThat(kthSmallest.kthSmallest(BinarySearchTreeNodeUtil.tree12(), 1)).isEqualTo(10);
    }

    @Test
    public void should_return_30_given_tree12_3() {
        assertThat(kthSmallest.kthSmallest(BinarySearchTreeNodeUtil.tree12(), 3)).isEqualTo(30);
    }

    @Test
    public void should_return_90_given_tree12_9() {
        assertThat(kthSmallest.kthSmallest(BinarySearchTreeNodeUtil.tree12(), 9)).isEqualTo(90);
    }
}
