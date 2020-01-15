package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _145_Test {
    _145_二叉树的后序遍历 postorder = new _145_二叉树的后序遍历();

    @Test
    public void should_return_empty_given_tree0() {
        assertThat(postorder.postorderTraversal1(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(postorder.postorderTraversal2(TreeNodeUtil.tree0()).size()).isEqualTo(0);
        assertThat(postorder.postorderTraversal3(TreeNodeUtil.tree0()).size()).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        assertThat(postorder.postorderTraversal1(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(postorder.postorderTraversal2(TreeNodeUtil.tree1()).size()).isEqualTo(1);
        assertThat(postorder.postorderTraversal3(TreeNodeUtil.tree1()).size()).isEqualTo(1);
    }

    @Test
    public void should_return_25431_given_tree5() {
        List<Integer> list1 = postorder.postorderTraversal1(TreeNodeUtil.tree5());
        assertPostTree5(list1);

        List<Integer> list2 = postorder.postorderTraversal2(TreeNodeUtil.tree5());
        assertPostTree5(list2);

        List<Integer> list3 = postorder.postorderTraversal3(TreeNodeUtil.tree5());
        assertPostTree5(list3);
    }

    @Test
    public void should_return_123_given_tree7() {
        List<Integer> list1 = postorder.postorderTraversal1(TreeNodeUtil.tree7());
        assertPostTree7(list1);

        List<Integer> list2 = postorder.postorderTraversal2(TreeNodeUtil.tree7());
        assertPostTree7(list2);

        List<Integer> list3 = postorder.postorderTraversal3(TreeNodeUtil.tree7());
        assertPostTree7(list3);
    }

    private void assertPostTree5(List<Integer> list) {
        assertThat(list.get(0)).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo(5);
        assertThat(list.get(2)).isEqualTo(4);
        assertThat(list.get(3)).isEqualTo(3);
        assertThat(list.get(4)).isEqualTo(1);
    }

    private void assertPostTree7(List<Integer> list) {
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }
}
