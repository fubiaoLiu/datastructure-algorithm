package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatedHeightTest {

    @Test
    public void should_return_0_given_tree0() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree0())).isEqualTo(0);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree0())).isEqualTo(0);
    }

    @Test
    public void should_return_1_given_tree1() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree1())).isEqualTo(1);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree1())).isEqualTo(1);
    }

    @Test
    public void should_return_2_given_tree2() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree2())).isEqualTo(2);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree2())).isEqualTo(2);
    }

    @Test
    public void should_return_2_given_tree3() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree3())).isEqualTo(2);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree3())).isEqualTo(2);
    }

    @Test
    public void should_return_3_given_tree4() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree4())).isEqualTo(3);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree4())).isEqualTo(3);
    }

    @Test
    public void should_return_4_given_tree5() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree5())).isEqualTo(4);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree5())).isEqualTo(4);
    }
    @Test
    public void should_return_4_given_tree6() {
        计算二叉树的高度 calculated = new 计算二叉树的高度();
        assertThat(calculated.calculatedHeight1(TreeNodeUtil.tree6())).isEqualTo(4);
        assertThat(calculated.calculatedHeight2(TreeNodeUtil.tree6())).isEqualTo(4);
    }
}
