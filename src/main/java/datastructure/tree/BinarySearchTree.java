package datastructure.tree;

import datastructure.tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 *
 * @author FuBiaoLiu
 * @since 2020/1/9
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        if (root == null) {
            root = new Node<>(element, null);
            size++;
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

        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }


    public void preorder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preorder(root, visitor);
    }

    private void preorder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    public void inorder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        inorder(node.left, visitor);
        visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    public void postorder(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        postorder(node.left, visitor);
        postorder(node.right, visitor);
        visitor.visit(node.element);
    }

    public void levelOrder(Visitor<E> visitor) {
        if (visitor == null || root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        Node<E> node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 迭代
     *
     * @return
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        Node<E> node;
        int size = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (--size == 0) {
                size = queue.size();
                height++;
            }
        }

        return height;
    }

    /**
     * 递归
     *
     * @return
     */
    public int height2() {
        return height(root);
    }

    private int height(Node<E> node) {
        return node == null ? 0 : Math.max(height(node.left), height(node.right)) + 1;
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
        if (replacement == null) {
            if (node.parent == null) {
                root = null;
            } else if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else {
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            } else if (node.parent.left == node) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
        }
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

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return root;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    private static class Node<E> {
        E element;
        Node left;
        Node right;
        Node parent;

        public Node(E element, Node parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

    }

    public static abstract class Visitor<E> {
        boolean stop;

        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
    }
}
