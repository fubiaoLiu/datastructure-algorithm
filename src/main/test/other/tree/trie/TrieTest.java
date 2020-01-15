package other.tree.trie;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrieTest {
    @Test
    public void should_success_add_get_clear_size() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("cata", 2);
        trie.add("catalog", 3);
        trie.add("god", 4);
        trie.add("数据结构", 5);
        trie.add("good", 6);
        trie.add("girl", 7);

        assertThat(trie.size()).isEqualTo(7);
        assertThat(trie.isEmpty()).isFalse();
        assertThat(trie.get("cat")).isEqualTo(1);
        assertThat(trie.get("cata")).isEqualTo(2);
        assertThat(trie.get("数据结构")).isEqualTo(5);

        trie.clear();
        assertThat(trie.size()).isEqualTo(0);
        assertThat(trie.isEmpty()).isTrue();
        assertThat(trie.get("cat")).isNull();
        assertThat(trie.get("cata")).isNull();
        assertThat(trie.get("数据结构")).isNull();
    }

    @Test
    public void should_success_remove() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("cata", 2);
        trie.add("catalog", 3);
        trie.add("god", 4);
        trie.add("数据结构", 5);
        trie.add("good", 6);
        trie.add("girl", 7);

        assertThat(trie.size()).isEqualTo(7);
        assertThat(trie.get("cat")).isEqualTo(1);

        trie.remove("god");
        assertThat(trie.size()).isEqualTo(6);
        assertThat(trie.get("god")).isNull();
        assertThat(trie.get("good")).isEqualTo(6);
        assertThat(trie.get("girl")).isEqualTo(7);

        trie.remove("cat");
        trie.remove("cata");
        trie.remove("catalog");
        trie.remove("数据结构");
        trie.remove("good");
        trie.remove("girl");
        assertThat(trie.size()).isEqualTo(0);
    }

    @Test
    public void should_success_startWith() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("cata", 2);
        trie.add("catalog", 3);
        trie.add("god", 4);
        trie.add("数据结构", 5);
        trie.add("good", 6);
        trie.add("girl", 7);

        assertThat(trie.startWith("g")).isTrue();
        assertThat(trie.startWith("god")).isTrue();
        assertThat(trie.startWith("goo")).isTrue();
        assertThat(trie.startWith("数")).isTrue();
        assertThat(trie.startWith("a")).isFalse();

        trie.remove("god");
        assertThat(trie.startWith("god")).isFalse();
        assertThat(trie.startWith("goo")).isTrue();
        assertThat(trie.startWith("go")).isTrue();
        assertThat(trie.startWith("a")).isFalse();

        trie.remove("good");
        assertThat(trie.startWith("go")).isFalse();
        trie.remove("girl");
        assertThat(trie.startWith("go")).isFalse();
        assertThat(trie.startWith("g")).isFalse();
        assertThat(trie.startWith("数")).isTrue();
        assertThat(trie.startWith("a")).isFalse();
    }

    @Test
    public void should_success_contains() {
        Trie<Integer> trie = new Trie<>();
        trie.add("cat", 1);
        trie.add("cata", 2);
        trie.add("catalog", 3);
        trie.add("god", 4);
        trie.add("数据结构", 5);
        trie.add("good", 6);
        trie.add("girl", 7);

        assertThat(trie.contains("g")).isFalse();
        assertThat(trie.contains("god")).isTrue();
        assertThat(trie.contains("goo")).isFalse();
        assertThat(trie.contains("数")).isFalse();
        assertThat(trie.contains("数据结构")).isTrue();
        assertThat(trie.contains("a")).isFalse();

        trie.remove("god");
        assertThat(trie.contains("god")).isFalse();

        trie.remove("数据结构");
        assertThat(trie.contains("数据结构")).isFalse();
    }
}
