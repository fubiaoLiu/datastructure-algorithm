package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _94_Test {
    _94_二叉树的中序遍历 inorder = new _94_二叉树的中序遍历();

    @Test
    public void should_return_empty_given_tree0(){
        assertThat(inorder.inorderTraversal1(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(inorder.inorderTraversal2(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(inorder.inorderTraversal3(TreeNodeUtil.tree0()).size()).isEqualTo(0);
    }
    @Test
    public void should_return_1_given_tree1(){
        assertThat(inorder.inorderTraversal1(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(inorder.inorderTraversal2(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(inorder.inorderTraversal3(TreeNodeUtil.tree1()).size()).isEqualTo(1);
    }
    @Test
    public void should_return_21345_given_tree5(){
        List<Integer> list1 = inorder.inorderTraversal1(TreeNodeUtil.tree5());
        assertThat(list1.get(0)).isEqualTo(2);
        assertThat(list1.get(1)).isEqualTo(1);
        assertThat(list1.get(2)).isEqualTo(3);
        assertThat(list1.get(3)).isEqualTo(4);
        assertThat(list1.get(4)).isEqualTo(5);

        List<Integer> list2 = inorder.inorderTraversal2(TreeNodeUtil.tree5());
        assertThat(list2.get(0)).isEqualTo(2);
        assertThat(list2.get(1)).isEqualTo(1);
        assertThat(list2.get(2)).isEqualTo(3);
        assertThat(list2.get(3)).isEqualTo(4);
        assertThat(list2.get(4)).isEqualTo(5);

        List<Integer> list3 = inorder.inorderTraversal3(TreeNodeUtil.tree5());
        assertThat(list3.get(0)).isEqualTo(2);
        assertThat(list3.get(1)).isEqualTo(1);
        assertThat(list3.get(2)).isEqualTo(3);
        assertThat(list3.get(3)).isEqualTo(4);
        assertThat(list3.get(4)).isEqualTo(5);
    }
}
