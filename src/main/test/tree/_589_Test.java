package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class _589_Test {
    @Test
    public void should_return_empty_given_tree0() {
        _589_N叉树的前序遍历 preOrder = new _589_N叉树的前序遍历();
        assertThat(preOrder.preorder1(NodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(preOrder.preorder2(NodeUtil.tree0()).size()).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        _589_N叉树的前序遍历 preOrder = new _589_N叉树的前序遍历();
        assertThat(preOrder.preorder1(NodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(preOrder.preorder2(NodeUtil.tree1()).size()).isEqualTo(1);
    }

    @Test
    public void should_return_12435_given_tree5() {
        _589_N叉树的前序遍历 preOrder = new _589_N叉树的前序遍历();
        List<Integer> list1 = preOrder.preorder1(NodeUtil.tree5());
        assertThat(list1.get(0)).isEqualTo(1);
        assertThat(list1.get(1)).isEqualTo(2);
        assertThat(list1.get(2)).isEqualTo(4);
        assertThat(list1.get(3)).isEqualTo(3);
        assertThat(list1.get(4)).isEqualTo(5);

        List<Integer> list2 = preOrder.preorder2(NodeUtil.tree5());
        assertThat(list2.get(0)).isEqualTo(1);
        assertThat(list2.get(1)).isEqualTo(2);
        assertThat(list2.get(2)).isEqualTo(4);
        assertThat(list2.get(3)).isEqualTo(3);
        assertThat(list2.get(4)).isEqualTo(5);
    }

    @Test
    public void should_return_1256734_given_tree6() {
        _589_N叉树的前序遍历 preOrder = new _589_N叉树的前序遍历();
        List<Integer> list1 = preOrder.preorder1(NodeUtil.tree6());
        assertThat(list1.get(0)).isEqualTo(1);
        assertThat(list1.get(1)).isEqualTo(2);
        assertThat(list1.get(2)).isEqualTo(5);
        assertThat(list1.get(3)).isEqualTo(6);
        assertThat(list1.get(4)).isEqualTo(7);
        assertThat(list1.get(5)).isEqualTo(3);
        assertThat(list1.get(6)).isEqualTo(4);

        List<Integer> list2 = preOrder.preorder2(NodeUtil.tree6());
        assertThat(list2.get(0)).isEqualTo(1);
        assertThat(list2.get(1)).isEqualTo(2);
        assertThat(list2.get(2)).isEqualTo(5);
        assertThat(list2.get(3)).isEqualTo(6);
        assertThat(list2.get(4)).isEqualTo(7);
        assertThat(list2.get(5)).isEqualTo(3);
        assertThat(list2.get(6)).isEqualTo(4);
    }
}
