package datastructure.unionfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 通用并查集 - 基于Quick Union和Rank、路径减半优化
 * @author: FuBiaoLiu
 * @date: 2020/1/24
 */
public class GenericUnionFind<E> {
    private Map<E, Node<E>> nodes = new HashMap<>();

    E find(E e) {
        Node<E> root = findRootNode(e);
        return root == null ? null : root.e;
    }

    void union(E e1, E e2) {
        Node<E> r1 = findRootNode(e1);
        Node<E> r2 = findRootNode(e2);
        if (r1 == null || r2 == null || Objects.equals(r1.e, r2.e)) {
            return;
        }
        if (r1.rank < r2.rank) {
            r1.parent = r2;
        } else if (r1.rank > r2.rank) {
            r2.parent = r1;
        } else {
            r1.parent = r2;
            r2.rank++;
        }
    }

    private Node<E> findRootNode(E e) {
        Node<E> node = nodes.get(e);
        if (node == null) {
            return null;
        }
        while (!Objects.equals(node.e, node.parent.e)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    boolean isSame(E e1, E e2) {
        return find(e1).equals(find(e2));
    }

    public void makeSet(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.parent = newNode;
        nodes.put(e, newNode);
    }

    private static class Node<E> {
        Node<E> parent;
        E e;
        int rank = 1;

        public Node(E e) {
            this.e = e;
        }
    }
}
