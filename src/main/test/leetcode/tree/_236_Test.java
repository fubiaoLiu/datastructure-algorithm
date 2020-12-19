package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class _236_Test {
    _236_二叉树的最近公共祖先 obj = new _236_二叉树的最近公共祖先();

    @Test
    public void test1() {
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(4);
        q.left = new TreeNode(0);
        q.right = new TreeNode(8);
        assertSame(root, obj.lowestCommonAncestor(root, p, q));
    }

    @Test
    public void test2() {
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        assertSame(root.left, obj.lowestCommonAncestor(root, root.left, root.left.right.right));
    }
}
