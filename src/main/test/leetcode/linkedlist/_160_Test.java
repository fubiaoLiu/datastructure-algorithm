package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class _160_Test {
    _160_相交链表 obj = new _160_相交链表();

    @Test
    public void test1() {
        ListNode target = new ListNode(8);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = target;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = target;
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        ListNode actual = obj.getIntersectionNode(headA, headB);

        assertSame(target, actual);
    }

    @Test
    public void test2() {
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);

        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);

        ListNode actual = obj.getIntersectionNode(headA, headB);

        assertSame(null, actual);
    }
}