package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.BinarySearchTreeNodeUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class _173_Test {

    @Test
    public void should_return_right_given_tree12() {
        _173_二叉搜索树迭代器 bstIterator = new _173_二叉搜索树迭代器(BinarySearchTreeNodeUtil.tree12());
        assertThat(bstIterator.hasNext()).isTrue();
        assertThat(bstIterator.next()).isEqualTo(10);
        assertThat(bstIterator.hasNext()).isTrue();
        assertThat(bstIterator.next()).isEqualTo(20);
        assertThat(bstIterator.next()).isEqualTo(30);
        assertThat(bstIterator.next()).isEqualTo(40);
        assertThat(bstIterator.next()).isEqualTo(50);
        assertThat(bstIterator.next()).isEqualTo(60);
        assertThat(bstIterator.next()).isEqualTo(70);
        assertThat(bstIterator.next()).isEqualTo(80);
        assertThat(bstIterator.next()).isEqualTo(90);
        assertThat(bstIterator.hasNext()).isFalse();
    }
}
