package datastructure.unionfind;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericUnionFindTest {
    @Test
    public void should_success_integer_find() {
        GenericUnionFind<Integer> uf = new GenericUnionFind<>();
        uf.makeSet(1);
        uf.makeSet(2);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);
    }

    @Test
    public void should_success_integer_union() {
        GenericUnionFind<Integer> uf = new GenericUnionFind<>();
        uf.makeSet(1);
        uf.makeSet(2);
        uf.makeSet(3);
        uf.makeSet(4);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(1, 2);
        assertThat(uf.find(1)).isEqualTo(2);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(3, 4);
        assertThat(uf.find(3)).isEqualTo(4);
        assertThat(uf.find(4)).isEqualTo(4);

        uf.union(1, 3);
        assertThat(uf.find(1)).isEqualTo(4);
        assertThat(uf.find(3)).isEqualTo(4);
    }

    @Test
    public void should_success_integer_isSame() {
        GenericUnionFind<Integer> uf = new GenericUnionFind<>();
        uf.makeSet(1);
        uf.makeSet(2);
        uf.makeSet(3);
        uf.makeSet(4);
        uf.makeSet(5);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(1, 2);
        assertThat(uf.isSame(1, 2)).isTrue();

        uf.union(3, 4);
        assertThat(uf.isSame(3, 4)).isTrue();

        uf.union(1, 3);
        assertThat(uf.isSame(1, 3)).isTrue();
        assertThat(uf.isSame(2, 4)).isTrue();

        assertThat(uf.isSame(2, 5)).isFalse();
    }

    @Test
    public void should_success_country_isSame() {
        GenericUnionFind<Country> uf = new GenericUnionFind<>();
        uf.makeSet(new Country(1, "A"));
        uf.makeSet(new Country(2, "B"));
        uf.makeSet(new Country(3, "C"));
        uf.makeSet(new Country(4, "D"));
        uf.makeSet(new Country(5, "E"));
        assertThat(uf.find(new Country(1, "A")).getName()).isEqualTo("A");
        assertThat(uf.find(new Country(2, "B")).getName()).isEqualTo("B");

        uf.union(new Country(1, "A"), new Country(2, "B"));
        assertThat(uf.isSame(new Country(1, "A"), new Country(2, "B"))).isTrue();

        uf.union(new Country(3, "C"), new Country(4, "D"));
        assertThat(uf.isSame(new Country(3, "C"), new Country(4, "D"))).isTrue();

        uf.union(new Country(1, "A"), new Country(3, "C"));
        assertThat(uf.isSame(new Country(1, "A"), new Country(3, "C"))).isTrue();
        assertThat(uf.isSame(new Country(2, "B"), new Country(4, "D"))).isTrue();

        assertThat(uf.isSame(new Country(2, "B"), new Country(5, "E"))).isFalse();
    }
}
