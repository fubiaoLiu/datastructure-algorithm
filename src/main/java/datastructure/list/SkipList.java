package datastructure.list;

import java.util.Comparator;

/**
 * 跳表
 * 最高层的层数是 log1/p(n)，平均有个 1/p 元素
 * 在搜索时，每一层链表的预期查找步数最多是 1/p，所以总的查找步数是 –logp(n/p)，时间复杂度是O(logn)
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/7
 */
public class SkipList<K, V> {
    private static final int MAX_LEVEL = 32;
    /**
     * 生成层数的概率，通常为 1/2 或 1/4
     */
    private static final double P = 0.25;
    private Node<K, V> first;
    private int level;
    private int size;
    private Comparator<K> comparator;

    public SkipList() {
        this(null);
    }

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        this.first = new Node<>(null, null, MAX_LEVEL);
    }

    public V put(K k, V v) {
        checkKey(k);
        Node<K, V> node = first;
        Node<K, V>[] preNodes = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> next;
            int cmp = -1;
            while ((next = node.nexts[i]) != null && (cmp = compare(k, next.key)) > 0) {
                node = next;
            }
            if (cmp == 0) {
                V oldV = next.value;
                next.value = v;
                return oldV;
            }
            preNodes[i] = node;
        }

        int newNodeLevel = randomLevel();
        Node<K, V> newNode = new Node<>(k, v, newNodeLevel);
        for (int i = 0; i < newNodeLevel; i++) {
            if (i < level) {
                newNode.nexts[i] = preNodes[i].nexts[i];
                preNodes[i].nexts[i] = newNode;
            } else {
                first.nexts[i] = newNode;
            }
        }
        if (newNodeLevel > level) {
            level = newNodeLevel;
        }
        size++;
        return null;
    }

    private int randomLevel() {
        int newLevel = 1;
        while (Math.random() < P && newLevel < MAX_LEVEL) {
            newLevel++;
        }
        return newLevel;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K k) {
        checkKey(k);
        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> next;
            int cmp = -1;
            while ((next = node.nexts[i]) != null && (cmp = compare(k, next.key)) > 0) {
                node = next;
            }
            if (cmp == 0) {
                return next.value;
            }
        }
        return null;
    }

    public V remove(K k) {
        checkKey(k);
        Node<K, V> node = first;
        Node<K, V>[] preNodes = new Node[level];
        Node<K, V> target = null;
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> next;
            int cmp = -1;
            while ((next = node.nexts[i]) != null && (cmp = compare(k, next.key)) > 0) {
                node = next;
            }
            if (cmp == 0) {
                target = next;
                preNodes[i] = node;
            }
        }
        if (target == null) {
            return null;
        }
        for (int i = 0; i < target.level; i++) {
            preNodes[i].nexts[i] = target.nexts[i];
        }
        size--;

        // 更新跳表层数
        while (level > 0 && first.nexts[level - 1] == null) {
            level--;
        }
        return target.value;
    }

    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>) k1).compareTo(k2);
    }

    private void checkKey(K k) {
        if (k == null) {
            throw new IllegalArgumentException("k cannot be null.");
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        int level;
        Node<K, V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key + ":" + value + "(" + level + ")";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("一共" + level + "层").append("\n");
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.nexts[i] != null) {
                sb.append(node.nexts[i]);
                sb.append(" ");
                node = node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
