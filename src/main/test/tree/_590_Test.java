package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class _590_Test {
    @Test
    public void should_return_empty_given_tree0() {
        _590_N叉树的后序遍历 postorder = new _590_N叉树的后序遍历();
        assertThat(postorder.postorder1(NodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(postorder.postorder2(NodeUtil.tree0()).size()).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        _590_N叉树的后序遍历 postorder = new _590_N叉树的后序遍历();
        assertThat(postorder.postorder1(NodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(postorder.postorder2(NodeUtil.tree1()).size()).isEqualTo(1);
    }

    @Test
    public void should_return_42531_given_tree5() {
        _590_N叉树的后序遍历 postorder = new _590_N叉树的后序遍历();
        List<Integer> list1 = postorder.postorder1(NodeUtil.tree5());
        assertThat(list1.get(0)).isEqualTo(4);
        assertThat(list1.get(1)).isEqualTo(2);
        assertThat(list1.get(2)).isEqualTo(5);
        assertThat(list1.get(3)).isEqualTo(3);
        assertThat(list1.get(4)).isEqualTo(1);

        List<Integer> list2 = postorder.postorder2(NodeUtil.tree5());
        assertThat(list2.get(0)).isEqualTo(4);
        assertThat(list2.get(1)).isEqualTo(2);
        assertThat(list2.get(2)).isEqualTo(5);
        assertThat(list2.get(3)).isEqualTo(3);
        assertThat(list2.get(4)).isEqualTo(1);
    }

    @Test
    public void should_return_5672341_given_tree6() {
        _590_N叉树的后序遍历 postorder = new _590_N叉树的后序遍历();
        List<Integer> list1 = postorder.postorder1(NodeUtil.tree6());
        assertThat(list1.get(0)).isEqualTo(5);
        assertThat(list1.get(1)).isEqualTo(6);
        assertThat(list1.get(2)).isEqualTo(7);
        assertThat(list1.get(3)).isEqualTo(2);
        assertThat(list1.get(4)).isEqualTo(3);
        assertThat(list1.get(5)).isEqualTo(4);
        assertThat(list1.get(6)).isEqualTo(1);

        List<Integer> list2 = postorder.postorder2(NodeUtil.tree6());
        assertThat(list2.get(0)).isEqualTo(5);
        assertThat(list2.get(1)).isEqualTo(6);
        assertThat(list2.get(2)).isEqualTo(7);
        assertThat(list2.get(3)).isEqualTo(2);
        assertThat(list2.get(4)).isEqualTo(3);
        assertThat(list2.get(5)).isEqualTo(4);
        assertThat(list2.get(6)).isEqualTo(1);
    }
}
