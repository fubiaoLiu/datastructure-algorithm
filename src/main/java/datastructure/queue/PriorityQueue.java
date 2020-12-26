package datastructure.queue;

import datastructure.heap.BinaryHeap;

import java.util.Comparator;

/**
 * @description: 优先级队列
 * @author FuBiaoLiu
 * @since 2020/1/14
 */
public class PriorityQueue<E> {
    BinaryHeap<E> heap;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<E> comparator) {
        heap = new BinaryHeap<>(comparator);
    }

    public void offer(E element) {
        heap.add(element);
    }

    public E poll() {
        return heap.remove();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    public E peek() {
        return heap.get();
    }
}
