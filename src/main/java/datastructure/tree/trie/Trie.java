package datastructure.tree.trie;


import java.util.HashMap;

/**
 * @description: trie
 * @author FuBiaoLiu
 * @since 2020/1/15
 */
public class Trie<V> {
    private Node<V> root;
    private int size;

    public V add(String key, V val) {
        checkKeyNotEmpty(key);

        if (root == null) {
            root = new Node<>(null);
        }

        int length = key.length();
        Node<V> node = root;
        for (int i = 0; i < length; i++) {
            char c = key.charAt(i);
            if (node.children == null) {
                node.children = new HashMap<>();
            }
            Node<V> childNode = node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node);
                childNode.key = c;
                node.children.put(c, childNode);
            }
            node = childNode;
        }

        // key已存在
        if (node.word) {
            V oldVal = node.val;
            node.val = val;
            return oldVal;
        }

        // 新增key
        node.val = val;
        node.word = true;
        size++;
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String key) {
        Node<V> node = node(key);
        return node != null && node.word;
    }

    public boolean startWith(String prefix) {
        return node(prefix) != null;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.word ? node.val : null;
    }

    public V remove(String key) {
        checkKeyNotEmpty(key);

        Node<V> node = node(key);
        if (node == null || !node.word) {
            return null;
        }
        size--;

        V oldVal = node.val;
        if (node.children != null && !node.children.isEmpty()) {
            node.word = false;
            node.val = null;
            return oldVal;
        }

        Node<V> parent;
        while ((parent = node.parent) != null) {
            parent.children.remove(node.key);
            if (parent.word || !parent.children.isEmpty()) {
                break;
            }
            node = node.parent;
        }

        return oldVal;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    private Node<V> node(String key) {
        checkKeyNotEmpty(key);

        int length = key.length();
        Node<V> node = root;
        char c;
        for (int i = 0; i < length; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            c = key.charAt(i);
            node = node.children.get(c);
        }

        return node;
    }

    private void checkKeyNotEmpty(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
    }

    private static class Node<V> {
        Node<V> parent;
        char key;
        V val;
        boolean word;
        HashMap<Character, Node<V>> children;

        public Node(Node<V> parent) {
            this.parent = parent;
        }
    }
}
