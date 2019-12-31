package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _102_Test {
    @Test
    public void should_return_empty_given_tree0(){
        _102_二叉树的层次遍历 levelOrder = new _102_二叉树的层次遍历();
        assertThat(levelOrder.levelOrder(TreeUtil.tree0()).size()).isEqualTo(0);
    }
    @Test
    public void should_return_1_given_tree1(){
        _102_二叉树的层次遍历 levelOrder = new _102_二叉树的层次遍历();
        assertThat(levelOrder.levelOrder(TreeUtil.tree1()).size()).isEqualTo(1);
        assertThat(levelOrder.levelOrder(TreeUtil.tree1()).get(0).size()).isEqualTo(1);
    }
    @Test
    public void should_return_1_23_4_5_given_tree5(){
        _102_二叉树的层次遍历 levelOrder = new _102_二叉树的层次遍历();
        List<List<Integer>> list = levelOrder.levelOrder(TreeUtil.tree5());
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0).get(0)).isEqualTo(1);
        assertThat(list.get(1).get(0)).isEqualTo(2);
        assertThat(list.get(1).get(1)).isEqualTo(3);
        assertThat(list.get(2).get(0)).isEqualTo(4);
        assertThat(list.get(3).get(0)).isEqualTo(5);
    }
}
