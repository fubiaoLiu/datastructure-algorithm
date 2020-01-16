package datastructure.list;

import java.util.StringJoiner;

/**
 * @description: 优化的动态数组
 * @author: FuBiaoLiu
 * @date: 2019/12/28
 */
public class OptimizedArrayList<E> {
    private static int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int first;
    private int size;

    public OptimizedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public OptimizedArrayList(int capacity) {
        capacity = capacity < 0 ? 0 : capacity;
        this.elements = (E[]) new Object[capacity];
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elements[getNextIndex()] = e;
        size++;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < oldCapacity; i++) {
                newElements[i] = elements[getRealIndex(i)];
            }
            elements = newElements;
            first = 0;
            System.out.println(oldCapacity + "扩容为" + newCapacity);
        }
    }

    private int getNextIndex() {
        return getRealIndex(size);
    }

    private int getLastIndex() {
        return getRealIndex(size - 1);
    }

    public void add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        index = getRealIndex(index);
        if (index == first) {
            first = first == 0 ? first + elements.length - 1 : first - 1;
            elements[first] = e;
        } else if (index == getNextIndex()) {
            elements[index] = e;
        } else {
            int length = elements.length;
            int mid = getRealIndex(size >> 1);
            if (index < mid) {
                first = --first < 0 ? first + length : first;
                int tmp1 = first > index ? index + length - 1 : index - 1;
                for (int i = first; i < tmp1; i++) {
                    int tmp2 = i >= length ? i - length : i;
                    elements[tmp2] = elements[convertIndex(i + 1)];
                }
                elements[index - 1] = e;
            } else {
                for (int i = getNextIndex(); i >= index; i = convertIndex(--i)) {
                    elements[i] = elements[convertIndex(i - 1)];
                }
                elements[index] = e;
            }
        }
        size++;
    }

    /**
     * 下标转换，如果下标不在数组的索引范围
     *
     * @param index
     * @return
     */
    private int convertIndex(int index) {
        int length = elements.length;
        return index < 0 ? index + length : (index >= length ? index - length : index);
    }

    /**
     * 获取当前索引的实际下标
     *
     * @param index
     * @return
     */
    private int getRealIndex(int index) {
        int length = elements.length;
        int tmp = first + index;
        return tmp >= length ? tmp - length : tmp;
    }

    /**
     * 获取当前下标的虚拟索引
     *
     * @param index
     * @return
     */
    private int getVirtualIndex(int index) {
        return index < first ? (index + elements.length - first) : (index - first);
    }


    public E remove(int index) {
        rangeCheck(index);
        E node = null;
        if (index == 0) {
            node = elements[first];
            first = convertIndex(first + 1);
        } else if (index != size - 1) {
            node = elements[getRealIndex(index)];
            int mid = size >> 1;
            if (index < mid) {
                for (int i = index; i > 0; i--) {
                    elements[getRealIndex(i)] = elements[getRealIndex(i - 1)];
                }
                first = convertIndex(first + 1);
            } else {
                for (int i = index + 1; i < size; i++) {
                    elements[getRealIndex(i - 1)] = elements[getRealIndex(i)];
                }
            }
        }
        size--;
        return node;
    }

    public E set(int index, E element) {
        rangeCheck(index);
        int realIndex = getRealIndex(index);
        E oldElement = elements[realIndex];
        elements[realIndex] = element;
        return oldElement;
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[getRealIndex(index)];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null && elements[getRealIndex(i)].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = 0;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Size:" + size + ",Index:" + index;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "Size:" + size + ",[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(elements[getRealIndex(i)].toString());
        }
        return joiner.toString();
    }
}
