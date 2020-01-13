package other.heap;

import tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @description: 二叉堆
 * @author: FuBiaoLiu
 * @date: 2020/1/13
 */
public class BinaryHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private int size;
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this(null);
    }

    public BinaryHeap(Comparator comparator) {
        this.comparator = comparator;
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {
        checkElementNotEmpty(element);
        ensureCapacity(size + 1);
        elements[size] = element;
        siftUp(size++);
    }

    public E get() {
        checkEmpty();
        return elements[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove() {
        checkEmpty();
        E root = elements[0];
        elements[0] = elements[--size];
        elements[size] = null;

        siftDown(0);

        return root;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        E[] newElements = (E[]) new Object[oldCapacity + (oldCapacity >> 1)];
        for (int i = 0; i < oldCapacity; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 上溢
     *
     * @param index
     */
    private void siftUp(int index) {
        E element = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            if (compare(element, elements[parentIndex]) <= 0) {
                break;
            }
            elements[index] = elements[parentIndex];
            index = parentIndex;
        }
        elements[index] = element;
    }

    /**
     * 下溢
     *
     * @param index
     */
    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < size && compare(child, elements[rightIndex]) < 0) {
                child = elements[childIndex = rightIndex];
            }

            if (compare(element, child) >= 0) {
                break;
            }
            elements[index] = elements[childIndex];
            index = childIndex;
        }
        elements[index] = element;
    }

    private int compare(E e1, E e2) {
        return comparator != null ?
                comparator.compare(e1, e2) : ((Comparable<E>) e1).compareTo(e2);
    }

    private void checkElementNotEmpty(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be empty.");
        }
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty.");
        }
    }

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return 0;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }

}
