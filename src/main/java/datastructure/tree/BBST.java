package datastructure.tree;

import java.util.Comparator;

/**
 * 红黑树
 *
 * @author FuBiaoLiu
 * @since 2020/1/10
 */
public class BBST<E> extends BST<E> {

    public BBST() {
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    protected void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> chlid = parent.left;
        grand.right = chlid;
        parent.left = grand;
        afterRotate(grand, parent, chlid);
    }

    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> chlid = parent.right;
        grand.left = chlid;
        parent.right = grand;
        afterRotate(grand, parent, chlid);
    }

    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> chlid) {
        // parent变成子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        if (chlid != null) {
            chlid.parent = grand;
        }

        grand.parent = parent;
    }
}
