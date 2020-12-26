package datastructure.heap;

import java.util.Comparator;

/**
 * 堆抽象类
 *
 * @author FuBiaoLiu
 * @since 2020/1/14
 */
public abstract class AbstractHeap<E> implements Heap<E> {
    protected int size;
    protected Comparator<E> comparator;

    public AbstractHeap() {
        this(null);
    }

    public AbstractHeap(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    protected int compare(E e1, E e2) {
        return comparator != null ?
                comparator.compare(e1, e2) : ((Comparable<E>) e1).compareTo(e2);
    }
}
