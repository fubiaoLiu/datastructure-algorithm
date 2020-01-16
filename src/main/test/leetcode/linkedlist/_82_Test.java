package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _82_Test {
    _82_删除排序链表中的重复元素2 deleteDuplicates = new _82_删除排序链表中的重复元素2();

    @Test
    public void should_return_given_list0() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list0());
        assertThat(head).isNull();
    }
    @Test
    public void should_return_given_list1() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list1());
        assertThat(head.val).isEqualTo(1);
    }

    @Test
    public void should_return_given_list2() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list2());
        assertThat(head).isNull();
    }
    @Test
    public void should_return_given_list3() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list3());
        assertThat(head.val).isEqualTo(2);
    }
    @Test
    public void should_return_given_list4() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list4());
        assertThat(head).isNull();
    }
    @Test
    public void should_return_given_list5() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list5());
        assertThat(head).isNull();
    }
    @Test
    public void should_return_given_list6() {
        ListNode head = deleteDuplicates.deleteDuplicates(LinkedListUtil.list6());
        assertThat(head.val).isEqualTo(2);
    }
}
