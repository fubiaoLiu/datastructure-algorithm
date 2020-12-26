package datastructure.heap;

import datastructure.tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * 二叉堆
 *
 * @author FuBiaoLiu
 * @since 2020/1/13
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this(null, null);
    }

    public BinaryHeap(E[] data) {
        this(data, null);
    }

    public BinaryHeap(Comparator comparator) {
        this(null, comparator);
    }

    public BinaryHeap(E[] data, Comparator comparator) {
        super(comparator);

        if (data != null && data.length != 0) {
            size = data.length;
            int capacity = data.length > DEFAULT_CAPACITY ? data.length : DEFAULT_CAPACITY;
            elements = (E[]) new Object[capacity];
            for (int i = 0; i < data.length; i++) {
                elements[i] = data[i];
            }

            heapify();
        } else {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public void add(E element) {
        checkElementNotEmpty(element);
        ensureCapacity(size + 1);
        elements[size] = element;
        siftUp(size++);
    }

    @Override
    public E get() {
        checkEmpty();
        return elements[0];
    }

    @Override
    public E remove() {
        checkEmpty();
        E root = elements[0];
        elements[0] = elements[--size];
        elements[size] = null;

        siftDown(0);

        return root;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        super.clear();
    }

    @Override
    public E replace(E element) {
        checkElementNotEmpty(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 批量建堆
     */
    private void heapify() {
        // 自上而下的上滤
		/*for (int i = 1; i < size; i++) {
			siftUp(i);
		}*/

        // 自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
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
     * 上滤
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
     * 下滤
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
