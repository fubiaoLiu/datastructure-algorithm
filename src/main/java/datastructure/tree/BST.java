package datastructure.tree;

import java.util.Comparator;

/**
 * 二叉搜索树2
 *
 * @author FuBiaoLiu
 * @since 2020/1/9
 */
public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    public void add(E element) {
        elementNotNullCheck(element);

        if (root == null) {
            root = createNode(element, null);
            size++;
            afterAdd(root);
            return;
        }

        Node<E> parent;
        Node<E> node = root;
        int cmp;
        if (comparator == null) {
            do {
                parent = node;
                cmp = compareTo(element, node.element);
                if (cmp > 0) {
                    node = node.right;
                } else if (cmp < 0) {
                    node = node.left;
                } else {
                    node.element = element;
                    return;
                }
            } while (node != null);
        } else {
            do {
                parent = node;
                cmp = comparator.compare(element, node.element);
                if (cmp > 0) {
                    node = node.right;
                } else if (cmp < 0) {
                    node = node.left;
                } else {
                    node.element = element;
                    return;
                }
            } while (node != null);
        }

        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

        afterAdd(newNode);
    }

    public Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    /**
     * 添加之后的处理
     *
     * @param node 新添加的节点
     */
    public void afterAdd(Node<E> node) {
    }

    public void remove(E element) {
        remove(node(element));
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private int compareTo(E e1, E e2) {
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;

        // node度为2
        if (node.hasTwoChildren()) {
            Node<E> pre = preNode(node);
            node.element = pre.element;
            node = pre;
        }

        Node<E> replacement = node.left == null ? node.right : node.left;
        // replacement为空则表示node为叶子节点
        if (replacement != null) {
            replacement.parent = node.parent;
        }

        if (node.parent == null) {
            root = replacement;
        } else if (node.parent.left == node) {
            node.parent.left = replacement;
        } else {
            node.parent.right = replacement;
        }

        if (replacement != null) {
            afterRemove(replacement);
        } else {
            afterRemove(node);
        }
    }

    /**
     * 删除之后的处理
     *
     * @param node 被删除的节点 或 替代被删除节点的子节点
     */
    public void afterRemove(Node<E> node) {
    }

    private Node<E> preNode(Node<E> node) {
        Node<E> pre = node.left;
        while (pre.right != null) {
            pre = pre.right;
        }
        return pre;
    }

    private Node<E> node(E element) {
        elementNotNullCheck(element);

        Node<E> node = root;
        if (comparator != null) {
            return findByCustomerCompare(element, node);
        }
        return findByDefaultCompare(element, node);
    }

    private Node<E> findByDefaultCompare(E element, Node<E> node) {
        while (node != null) {
            int cmp = compareTo(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    private Node<E> findByCustomerCompare(E element, Node<E> node) {
        while (node != null) {
            int cmp = comparator.compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

}
