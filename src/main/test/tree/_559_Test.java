package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _559_Test {
    @Test
    public void should_return_0_given_tree0() {
        _559_N叉树的最大深度 maxDepth = new _559_N叉树的最大深度();
        assertThat(maxDepth.maxDepth1(NodeUtil.tree0())).isEqualTo(0);
        assertThat(maxDepth.maxDepth2(NodeUtil.tree0())).isEqualTo(0);
        assertThat(maxDepth.maxDepth3(NodeUtil.tree0())).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        _559_N叉树的最大深度 maxDepth = new _559_N叉树的最大深度();
        assertThat(maxDepth.maxDepth1(NodeUtil.tree1())).isEqualTo(1);
        assertThat(maxDepth.maxDepth2(NodeUtil.tree1())).isEqualTo(1);
        assertThat(maxDepth.maxDepth3(NodeUtil.tree1())).isEqualTo(1);
    }
    @Test
    public void should_return_3_given_tree5(){
        _559_N叉树的最大深度 maxDepth = new _559_N叉树的最大深度();
        assertThat(maxDepth.maxDepth1(NodeUtil.tree5())).isEqualTo(3);
        assertThat(maxDepth.maxDepth2(NodeUtil.tree5())).isEqualTo(3);
        assertThat(maxDepth.maxDepth3(NodeUtil.tree5())).isEqualTo(3);
    }

    @Test
    public void should_return_3_given_tree6(){
        _559_N叉树的最大深度 maxDepth = new _559_N叉树的最大深度();
        assertThat(maxDepth.maxDepth1(NodeUtil.tree6())).isEqualTo(3);
        assertThat(maxDepth.maxDepth2(NodeUtil.tree6())).isEqualTo(3);
        assertThat(maxDepth.maxDepth3(NodeUtil.tree6())).isEqualTo(3);
    }
}
