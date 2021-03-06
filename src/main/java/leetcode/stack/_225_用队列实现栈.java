package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * Related Topics 栈 设计
 * <p>
 * https://leetcode-cn.com/problems/implement-stack-using-queues
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/28
 */
public class _225_用队列实现栈 {

    private Deque<Integer> deque = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public _225_用队列实现栈() {

    }

    /**
     * Push element x onto leetcode.stack.
     */
    public void push(int x) {
        deque.addFirst(x);
    }

    /**
     * Removes the element on top of the leetcode.stack and returns that element.
     */
    public int pop() {
        return deque.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return deque.peekFirst();
    }

    /**
     * Returns whether the leetcode.stack is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}
