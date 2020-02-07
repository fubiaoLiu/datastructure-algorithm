package datastructure.list;

import algorithm.sort.tools.Times;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class SkipListTest {
    @Test
    public void test() {
        SkipList<Integer, Integer> skipList = new SkipList<>();
        int count = 100_0000;
        for (int i = 1; i <= count; i++) {
            skipList.put(i, i);
        }
        assertThat(skipList.size()).isEqualTo(count);
        for (int i = 1; i <= count; i++) {
            assertThat(skipList.get(i)).isEqualTo(i);
        }
//        System.out.println(skipList);
        for (int i = 1; i <= count; i++) {
            assertThat(skipList.remove(i)).isEqualTo(i);
        }
        assertThat(skipList.size()).isEqualTo(0);
    }

    @Test
    public void test_skiplist_and_treemap_time() {
        int count = 100_0000;
        int delta = 10;
        // 这里两个要分两次单独执行，同时执行第二个执行速度比较快，猜测虚拟机有做优化
        test_skiplist_time(count, delta);
//        test_treemap_time(count, delta);
    }

    private void test_skiplist_time(int count, int delta) {
        SkipList<Integer, Integer> list = new SkipList<>();
        Times.test("SkipList", () -> {
            test_skiplist(list, count, delta);
        });
    }

    private void test_treemap_time(int count, int delta) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Times.test("TreeMap", () -> {
            test_treemap(map, count, delta);
        });
    }

    private void test_skiplist(SkipList<Integer, Integer> list, int count, int delta) {
        for (int i = 0; i < count; i++) {
            list.put(i, i + delta);
        }
        for (int i = 0; i < count; i++) {
            assertThat(list.get(i)).isEqualTo(i + delta);
        }
        assertThat(list.size()).isEqualTo(count);
        for (int i = 0; i < count; i++) {
            assertThat(list.remove(i)).isEqualTo(i + delta);
        }
        assertThat(list.size()).isEqualTo(0);
    }

    private void test_treemap(TreeMap<Integer, Integer> map, int count, int delta) {
        for (int i = 0; i < count; i++) {
            map.put(i, i + delta);
        }
        for (int i = 0; i < count; i++) {
            assertThat(map.get(i)).isEqualTo(i + delta);
        }
        assertThat(map.size()).isEqualTo(count);
        for (int i = 0; i < count; i++) {
            assertThat(map.remove(i)).isEqualTo(i + delta);
        }
        assertThat(map.size()).isEqualTo(0);
    }
}
