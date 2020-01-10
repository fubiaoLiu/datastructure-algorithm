package other.tree;

import java.util.Comparator;

/**
 * @description: 红黑树
 * @author: FuBiaoLiu
 * @date: 2020/1/10
 */
public class RBTree<E> extends BST<E> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public RBTree() {
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    public void afterAdd(Node<E> node) {
        RBNode<E> parent = (RBNode<E>) node.parent;
        // 添加的为根节点
        if (parent == null) {
            black(node);
            return;
        }
        // 父节点是黑的
        if (isBlack(parent)) {
            return;
        }
        RBNode<E> grand = (RBNode<E>) parent.parent;
        RBNode<E> uncle = sibling(parent);
        // 父节点是红的
        if (isRed(uncle)) {
            // 叔父节点是红的
            black(parent);
            black(uncle);
            red(grand);
            afterAdd(grand);
        } else {
            // 叔父节点是黑的
            if (parent.isLeftChild()) {// L
                if (node.isLeftChild()) {// LL
                    black(parent);
                    red(grand);
                    rotateRight(grand);
                } else {// LR
                    black(node);
                    red(grand);
                    rotateLeft(parent);
                    rotateRight(grand);
                }
            } else {// R
                if (node.isLeftChild()) {// RL
                    black(node);
                    red(grand);
                    rotateRight(parent);
                    rotateLeft(grand);
                } else {// RR
                    black(parent);
                    red(grand);
                    rotateLeft(grand);
                }
            }
        }

    }

    @Override
    public void afterRemove(Node<E> node) {

    }

    @Override
    public Node<E> createNode(E element, Node<E> parent) {
        return new RBNode(element, parent);
    }

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }
        grand.right = parent.left;
        if (parent.left != null) {
            parent.left.parent = grand;
        }
        parent.left = grand;
        grand.parent = parent;
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }
        grand.left = parent.right;
        if (parent.right != null) {
            parent.right.parent = grand;
        }
        parent.right = grand;
        grand.parent = parent;
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private RBNode<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private RBNode<E> red(Node<E> node) {
        return color(node, RED);
    }

    private RBNode<E> sibling(Node<E> node) {
        if (node == null || node.parent == null) {
            return null;
        }
        return (RBNode<E>) (node.isLeftChild() ? node.parent.right : node.parent.left);
    }

    private RBNode<E> color(Node<E> node, boolean color) {
        if (node != null) {
            ((RBNode<E>) node).color = color;
        }
        return (RBNode<E>) node;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        RBNode<E> myNode = (RBNode<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        String color = myNode.color == RED ? "R_" : "";
        return color + myNode.element + "_p(" + parentString + ")";
    }

    protected static class RBNode<E> extends Node<E> {
        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }
}
