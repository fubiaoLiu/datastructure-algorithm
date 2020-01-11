package other.tree;

import java.util.Comparator;

/**
 * @description: 红黑树
 * @author: FuBiaoLiu
 * @date: 2020/1/10
 */
public class RBTree<E> extends BBST<E> {
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
        // 父节点是红的(B树节点上溢)
        if (isRed(uncle)) {
            // 叔父节点是红的
            black(parent);
            black(uncle);
            red(grand);
            afterAdd(grand);
        } else {
            // 叔父节点是黑的
            red(grand);
            if (parent.isLeftChild()) {// L
                if (node.isLeftChild()) {// LL
                    black(parent);
                } else {// LR
                    black(node);
                    rotateLeft(parent);
                }
                rotateRight(grand);
            } else {// R
                if (node.isLeftChild()) {// RL
                    black(node);
                    rotateRight(parent);
                } else {// RR
                    black(parent);
                }
                rotateLeft(grand);
            }
        }

    }

    @Override
    public void afterRemove(Node<E> node) {
        // 真正被删除的元素都在叶子节点
        // 如果被删除的节点 或 用以取代删除节点的子节点是RED，直接染黑
        if (isRed(node)) {
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        // 删除的是根节点
        if (parent == null) {
            return;
        }

        // 删除的是BLACK节点(B树节点下溢)
        // 被删除的节点是左还是右
        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;

        if (left) {// 被删除的节点在左边
            // sibling是RED，旋转，更换兄弟节点
            if (isRed(sibling)) {
                red(parent);
                black(sibling);
                rotateLeft(parent);
                sibling = parent.right;
            }

            // 此时sibling必然是BLACK
            if (isBlack(sibling.right) && isBlack(sibling.left)) {
                // 如果sibling的子节点都是BLACK的，父节点向下跟兄弟节点合并
                red(sibling);
                if (isBlack(parent)) {
                    afterRemove(parent);
                } else {
                    black(parent);
                }
            } else {
                // 如果sibling有RED的子节点，就向sibling借
                if (isRed(sibling.left)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }

                color(sibling, colorOf(parent));
                black(parent);
                black(sibling.right);
                rotateLeft(parent);
            }
        } else {
            // sibling是RED，旋转，更换兄弟节点
            if (isRed(sibling)) {
                red(parent);
                black(sibling);
                rotateRight(parent);
                sibling = parent.left;
            }

            // 此时sibling必然是BLACK
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // 如果sibling的子节点都是BLACK的，父节点向下跟兄弟节点合并
                red(sibling);
                if (isBlack(parent)) {
                    afterRemove(parent);
                } else {
                    black(parent);
                }
            } else {
                // 如果sibling有RED的子节点，就向sibling借
                if (isRed(sibling.right)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }

                color(sibling, colorOf(parent));
                black(parent);
                black(sibling.left);
                rotateRight(parent);
            }
        }
    }

    @Override
    public Node<E> createNode(E element, Node<E> parent) {
        return new RBNode(element, parent);
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
