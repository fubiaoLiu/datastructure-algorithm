package algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void should_return_true_test_fib1() {
        assertThat(fibonacci.fib1(1)).isEqualTo(1);
        assertThat(fibonacci.fib1(2)).isEqualTo(1);
        assertThat(fibonacci.fib1(3)).isEqualTo(2);
        assertThat(fibonacci.fib1(4)).isEqualTo(3);
        assertThat(fibonacci.fib1(5)).isEqualTo(5);
        assertThat(fibonacci.fib1(6)).isEqualTo(8);
        assertThat(fibonacci.fib1(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib2() {
        assertThat(fibonacci.fib2(1)).isEqualTo(1);
        assertThat(fibonacci.fib2(2)).isEqualTo(1);
        assertThat(fibonacci.fib2(3)).isEqualTo(2);
        assertThat(fibonacci.fib2(4)).isEqualTo(3);
        assertThat(fibonacci.fib2(5)).isEqualTo(5);
        assertThat(fibonacci.fib2(6)).isEqualTo(8);
        assertThat(fibonacci.fib2(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib3() {
        assertThat(fibonacci.fib3(1)).isEqualTo(1);
        assertThat(fibonacci.fib3(2)).isEqualTo(1);
        assertThat(fibonacci.fib3(3)).isEqualTo(2);
        assertThat(fibonacci.fib3(4)).isEqualTo(3);
        assertThat(fibonacci.fib3(5)).isEqualTo(5);
        assertThat(fibonacci.fib3(6)).isEqualTo(8);
        assertThat(fibonacci.fib3(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib4() {
        assertThat(fibonacci.fib4(1)).isEqualTo(1);
        assertThat(fibonacci.fib4(2)).isEqualTo(1);
        assertThat(fibonacci.fib4(3)).isEqualTo(2);
        assertThat(fibonacci.fib4(4)).isEqualTo(3);
        assertThat(fibonacci.fib4(5)).isEqualTo(5);
        assertThat(fibonacci.fib4(6)).isEqualTo(8);
        assertThat(fibonacci.fib4(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib5() {
        assertThat(fibonacci.fib5(1)).isEqualTo(1);
        assertThat(fibonacci.fib5(2)).isEqualTo(1);
        assertThat(fibonacci.fib5(3)).isEqualTo(2);
        assertThat(fibonacci.fib5(4)).isEqualTo(3);
        assertThat(fibonacci.fib5(5)).isEqualTo(5);
        assertThat(fibonacci.fib5(6)).isEqualTo(8);
        assertThat(fibonacci.fib5(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib6() {
        assertThat(fibonacci.fib6(1)).isEqualTo(1);
        assertThat(fibonacci.fib6(2)).isEqualTo(1);
        assertThat(fibonacci.fib6(3)).isEqualTo(2);
        assertThat(fibonacci.fib6(4)).isEqualTo(3);
        assertThat(fibonacci.fib6(5)).isEqualTo(5);
        assertThat(fibonacci.fib6(6)).isEqualTo(8);
        assertThat(fibonacci.fib6(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib7() {
        assertThat(fibonacci.fib7(1)).isEqualTo(1);
        assertThat(fibonacci.fib7(2)).isEqualTo(1);
        assertThat(fibonacci.fib7(3)).isEqualTo(2);
        assertThat(fibonacci.fib7(4)).isEqualTo(3);
        assertThat(fibonacci.fib7(5)).isEqualTo(5);
        assertThat(fibonacci.fib7(6)).isEqualTo(8);
        assertThat(fibonacci.fib7(10)).isEqualTo(55);
    }

    @Test
    public void should_return_true_test_fib8() {
        assertThat(fibonacci.fib8(1)).isEqualTo(1);
        assertThat(fibonacci.fib8(2)).isEqualTo(1);
        assertThat(fibonacci.fib8(3)).isEqualTo(2);
        assertThat(fibonacci.fib8(4)).isEqualTo(3);
        assertThat(fibonacci.fib8(5)).isEqualTo(5);
        assertThat(fibonacci.fib8(6)).isEqualTo(8);
        assertThat(fibonacci.fib8(10)).isEqualTo(55);
    }
}
