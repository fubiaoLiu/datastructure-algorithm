package datastructure.heap;

/**
 * 堆顶层接口
 *
 * @author FuBiaoLiu
 * @since 2020/1/14
 */
public interface Heap<E> {
    void add(E element);

    E get();

    int size();

    boolean isEmpty();

    E remove();

    void clear();

    E replace(E element);
}
