package datastructure.tree;

import org.junit.jupiter.api.Test;
import datastructure.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RBTreeTest {
    @Test
    public void test_add() {
        Integer data[] = new Integer[]{
                64, 27, 4, 90, 67, 1, 65, 100, 3, 56, 72, 50, 24, 28, 5, 91, 94, 62, 45, 33
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            System.out.println("【" + data[i] + "】");
            rb.add(data[i]);
            BinaryTrees.println(rb);
            System.out.println("------------------------------");
        }
//        BinaryTrees.println(rb);
    }

    @Test
    public void test_remove() {
        Integer data[] = new Integer[]{
                64, 27, 4, 90, 67, 1, 65, 100, 3, 56, 72, 50, 24, 28, 5, 91, 94, 62, 45, 33
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println("【" + data[i] + "】");
            rb.remove(data[i]);
            BinaryTrees.println(rb);
            System.out.println("------------------------------");
        }
    }

    @Test
    public void test_clear_size() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        assertThat(rb.size()).isEqualTo(data.length);
        rb.clear();
        BinaryTrees.println(rb);
        assertThat(rb.size()).isEqualTo(0);
    }

    @Test
    public void test_contains() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        assertThat(rb.contains(9)).isTrue();
        assertThat(rb.contains(8)).isTrue();
        assertThat(rb.contains(11)).isTrue();
        assertThat(rb.contains(10)).isFalse();
    }

    @Test
    public void test_preorder() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        rb.preorder(new RBTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("[" + element + "]");
                return false;
            }
        });
    }

    @Test
    public void test_inorder() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        rb.inorder(new RBTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("[" + element + "]");
                return false;
            }
        });
    }

    @Test
    public void test_postorder() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        rb.postorder(new RBTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("[" + element + "]");
                return false;
            }
        });
    }

    @Test
    public void test_levelOrder() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        rb.levelOrder(new RBTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("[" + element + "]");
                return false;
            }
        });
    }

    @Test
    public void test_height() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        assertThat(rb.height()).isEqualTo(4);
    }

    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
        }
    }

    @Test
    public void test_comparator() {
        RBTree<Person> rb = new RBTree<>(new PersonComparator());
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            rb.add(new Person("user" + i, random.nextInt(20)));
        }
        BinaryTrees.println(rb);
        System.out.println("------------------------------");

        rb.inorder(new RBTree.Visitor<Person>() {
            @Override
            public boolean visit(Person element) {
                System.out.print("[" + element + "]");
                return false;
            }
        });
    }
}
