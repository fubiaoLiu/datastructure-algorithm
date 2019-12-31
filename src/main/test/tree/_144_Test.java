package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _144_Test {
    @Test
    public void should_return_empty_given_tree0(){
        _144_二叉树的前序遍历 preOrder = new _144_二叉树的前序遍历();
        assertThat(preOrder.preorderTraversal1(TreeUtil.tree0()).size()).isEqualTo(0);
        assertThat(preOrder.preorderTraversal2(TreeUtil.tree0()).size()).isEqualTo(0);
    }
    @Test
    public void should_return_1_given_tree1(){
        _144_二叉树的前序遍历 preOrder = new _144_二叉树的前序遍历();
        assertThat(preOrder.preorderTraversal1(TreeUtil.tree1()).size()).isEqualTo(1);
        assertThat(preOrder.preorderTraversal2(TreeUtil.tree1()).size()).isEqualTo(1);
    }
    @Test
    public void should_return_12345_given_tree5(){
        _144_二叉树的前序遍历 preOrder = new _144_二叉树的前序遍历();
        List<Integer> list1 = preOrder.preorderTraversal1(TreeUtil.tree5());
        assertThat(list1.get(0)).isEqualTo(1);
        assertThat(list1.get(1)).isEqualTo(2);
        assertThat(list1.get(2)).isEqualTo(3);
        assertThat(list1.get(3)).isEqualTo(4);
        assertThat(list1.get(4)).isEqualTo(5);

        List<Integer> list2 = preOrder.preorderTraversal2(TreeUtil.tree5());
        assertThat(list2.get(0)).isEqualTo(1);
        assertThat(list2.get(1)).isEqualTo(2);
        assertThat(list2.get(2)).isEqualTo(3);
        assertThat(list2.get(3)).isEqualTo(4);
        assertThat(list2.get(4)).isEqualTo(5);
    }
}
