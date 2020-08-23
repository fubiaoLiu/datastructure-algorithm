package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class _2_Test {
    _2_两数相加 twoNumbersAdd = new _2_两数相加();

    @Test
    public void should_return_807_given_342_465() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);

        LinkedList<Integer> result = twoNumbersAdd.add(list1, list2);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(7, result.get(0));
        assertEquals(0, result.get(1));
        assertEquals(8, result.get(2));
    }

    @Test
    public void should_return_310_given_100_210() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(0);
        list1.add(0);
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(0);
        list2.add(1);
        list2.add(2);

        LinkedList<Integer> result = twoNumbersAdd.add(list1, list2);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
        assertEquals(3, result.get(2));
    }

    @Test
    public void should_return_1998_given_999_999() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(9);
        list1.add(9);
        list1.add(9);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(9);
        list2.add(9);
        list2.add(9);

        LinkedList<Integer> result = twoNumbersAdd.add(list1, list2);
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(8, result.get(0));
        assertEquals(9, result.get(1));
        assertEquals(9, result.get(2));
        assertEquals(1, result.get(3));
    }
}
