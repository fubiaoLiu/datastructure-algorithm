package tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class _108_Test {
    _108_将有序数组转换为二叉搜索树 sortedArrayToBST = new _108_将有序数组转换为二叉搜索树();

    @Test
    public void should_return_bst_given_array0() {
        int[] nums = new int[]{};
        TreeNode root = sortedArrayToBST.sortedArrayToBST(nums);
        assertThat(root).isNull();
    }

    @Test
    public void should_return_bst_given_array1() {
        int[] nums = new int[]{5};
        TreeNode root = sortedArrayToBST.sortedArrayToBST(nums);
        assertThat(root.val).isEqualTo(5);
    }

    @Test
    public void should_return_bst_given_array2() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST.sortedArrayToBST(nums);
        assertThat(root.val).isEqualTo(0);
        assertThat(root.left.val).isEqualTo(-10);
        assertThat(root.left.right.val).isEqualTo(-3);
        assertThat(root.right.val).isEqualTo(5);
        assertThat(root.right.right.val).isEqualTo(9);
    }
}
