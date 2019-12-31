package tree;

public class TreeUtil {
    public static TreeNode tree0() {
        return null;
    }

    public static TreeNode tree1() {
        return new TreeNode(1);
    }

    public static TreeNode tree2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        return node1;
    }

    public static TreeNode tree3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    public static TreeNode tree4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        return node1;
    }

    /**
     * @return
     */
    public static TreeNode tree5() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.right = node5;
        return node1;
    }

    /**
     * @return
     */
    public static TreeNode tree6() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node1.right = node6;
        node6.left = node5;
        node6.right = node7;
        return node1;
    }
    /**
     * @return
     */
    public static TreeNode tree7() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;
        return node3;
    }
}
