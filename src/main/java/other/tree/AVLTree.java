package other.tree;

import java.util.Comparator;

/**
 * @description: AVL树
 * @author: FuBiaoLiu
 * @date: 2020/1/10
 */
public class AVLTree<E> extends BST<E> {
    public AVLTree() {
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    public void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 平衡则更新高度
                updateHeight(node);
            } else {
                // 恢复平衡
                rebalance(node);
                break;
            }
        }
    }

    @Override
    public void afterRemove(Node<E> node) {
        while ((node = node.parent) != null){
            if (isBalanced(node)) {
                // 平衡则更新高度
                updateHeight(node);
            } else {
                // 恢复平衡
                rebalance(node);
            }
        }
    }

    @Override
    public Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode(element, parent);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        int left = (node.left == null) ? 0 : ((AVLNode<E>) node.left).height;
        int right = (node.right == null) ? 0 : ((AVLNode<E>) node.right).height;
        ((AVLNode<E>) node).height = Math.max(left, right) + 1;
    }

    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL
                rotateRight(grand);
            } else { // LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {// R
            if (node.isLeftChild()) { // RL
                rotateRight(parent);
                rotateLeft(grand);
            } else { // RR
                rotateLeft(grand);
            }
        }
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

        updateHeight(grand);
        updateHeight(parent);
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

        updateHeight(grand);
        updateHeight(parent);
    }


    protected static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = (left == null) ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = (right == null) ? 0 : ((AVLNode<E>) right).height;
            return leftHeight - rightHeight;
        }

        public Node<E> tallerChild() {
            int leftHeight = (left == null) ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = (right == null) ? 0 : ((AVLNode<E>) right).height;
            if (leftHeight > rightHeight) {
                return left;
            } else if (leftHeight < rightHeight) {
                return right;
            }
            return isLeftChild() ? left : right;
        }
    }
}
