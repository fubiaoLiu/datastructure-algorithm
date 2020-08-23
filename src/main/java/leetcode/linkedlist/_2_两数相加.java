package leetcode.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @description: 两数相加
 * @author: liufb
 * @create: 2020/8/14 13:49
 **/
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
