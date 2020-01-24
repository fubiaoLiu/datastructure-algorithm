package datastructure.unionfind;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnionFind_QFTest {
    @Test
    public void should_success_find(){
        UnionFind uf = new UnionFind_QF(10);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);
    }

    @Test
    public void should_success_union(){
        UnionFind uf = new UnionFind_QF(10);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(1,2);
        assertThat(uf.find(1)).isEqualTo(2);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(3,4);
        assertThat(uf.find(3)).isEqualTo(4);
        assertThat(uf.find(4)).isEqualTo(4);

        uf.union(1,3);
        assertThat(uf.find(1)).isEqualTo(4);
        assertThat(uf.find(3)).isEqualTo(4);
    }

    @Test
    public void should_success_isSame(){
        UnionFind uf = new UnionFind_QF(10);
        assertThat(uf.find(1)).isEqualTo(1);
        assertThat(uf.find(2)).isEqualTo(2);

        uf.union(1,2);
        assertThat(uf.isSame(1,2)).isTrue();

        uf.union(3,4);
        assertThat(uf.isSame(3,4)).isTrue();

        uf.union(1,3);
        assertThat(uf.isSame(1,3)).isTrue();
        assertThat(uf.isSame(2,4)).isTrue();

        assertThat(uf.isSame(2,5)).isFalse();
    }
}
