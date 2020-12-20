package leetcode.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author FuBiaoLiu
 * @since 2020/12/20
 */
public class _2_两数相加 {
    public LinkedList<Integer> add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        LinkedList<Integer> longer = list1.size() > list2.size() ? list1 : list2;
        LinkedList<Integer> shorter = list1.size() > list2.size() ? list2 : list1;

        LinkedList<Integer> result = new LinkedList<>();
        Iterator<Integer> longerIterator = longer.iterator();
        Iterator<Integer> shorterIterator = shorter.iterator();
        int lastCarry = 0;
        int current;
        for (int i = 0; i < longer.size(); i++) {
            current = longerIterator.next() + lastCarry;
            if (i < shorter.size()) {
                current += shorterIterator.next();
            }
            if (current >= 10) {
                lastCarry = 1;
                result.add(current - 10);
            } else {
                lastCarry = 0;
                result.add(current);
            }
        }
        if (lastCarry == 1) {
            result.add(lastCarry);
        }

        return result;
    }
}
