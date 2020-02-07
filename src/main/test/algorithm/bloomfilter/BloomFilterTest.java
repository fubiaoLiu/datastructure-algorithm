package algorithm.bloomfilter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BloomFilterTest {
    @Test
    public void should_success_test_put_contains() {
        BloomFilter<Integer> bf = new BloomFilter<>(100, 0.01);
        assertThat(bf.put(1)).isTrue();
        assertThat(bf.contains(1)).isTrue();
    }

    @Test
    public void should_success_test_p() {
        int n = 10_00_0000;
        double p = 0.01;
        BloomFilter<Integer> bf = new BloomFilter<>(n, p);
        for (int i = 1; i <= n; i++) {
            bf.put(i);
        }

        int contain = 0;
        for (int i = 1; i <= n; i++) {
            if (bf.contains(i)) {
                contain++;
            }
        }
        System.out.println(contain);
        assertThat(contain).isEqualTo(n);

        int count = 0;
        int end = n << 1;
        for (int i = n + 1; i <= end; i++) {
            if (bf.contains(i)) {
                count++;
            }
        }
        System.out.println(count);
        assertThat(count).isLessThan((int) (n * p));
    }
}
