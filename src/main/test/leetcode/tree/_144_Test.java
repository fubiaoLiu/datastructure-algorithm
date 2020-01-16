package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _144_Test {
    _144_二叉树的前序遍历 preorder = new _144_二叉树的前序遍历();
    @Test
    public void should_return_empty_given_tree0(){
        assertThat(preorder.preorderTraversal1(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(preorder.preorderTraversal2(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(preorder.preorderTraversal3(TreeNodeUtil.tree0()).size()).isEqualTo(0);
    }
    @Test
    public void should_return_1_given_tree1(){
        assertThat(preorder.preorderTraversal1(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(preorder.preorderTraversal2(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(preorder.preorderTraversal3(TreeNodeUtil.tree1()).size()).isEqualTo(1);
    }
    @Test
    public void should_return_12345_given_tree5(){
        List<Integer> list1 = preorder.preorderTraversal1(TreeNodeUtil.tree5());
        assertThat(list1.get(0)).isEqualTo(1);
        assertThat(list1.get(1)).isEqualTo(2);
        assertThat(list1.get(2)).isEqualTo(3);
        assertThat(list1.get(3)).isEqualTo(4);
        assertThat(list1.get(4)).isEqualTo(5);

        List<Integer> list2 = preorder.preorderTraversal2(TreeNodeUtil.tree5());
        assertThat(list2.get(0)).isEqualTo(1);
        assertThat(list2.get(1)).isEqualTo(2);
        assertThat(list2.get(2)).isEqualTo(3);
        assertThat(list2.get(3)).isEqualTo(4);
        assertThat(list2.get(4)).isEqualTo(5);

        List<Integer> list3 = preorder.preorderTraversal3(TreeNodeUtil.tree5());
        assertThat(list3.get(0)).isEqualTo(1);
        assertThat(list3.get(1)).isEqualTo(2);
        assertThat(list3.get(2)).isEqualTo(3);
        assertThat(list3.get(3)).isEqualTo(4);
        assertThat(list3.get(4)).isEqualTo(5);
    }
}
