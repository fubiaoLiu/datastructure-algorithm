package algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ClimbStairsTest {
    ClimbStairs climbStairs = new ClimbStairs();
    @Test
    public void should_return_success_test_climbStairs1(){
        assertThat(climbStairs.climbStairs1(1)).isEqualTo(1);
        assertThat(climbStairs.climbStairs1(2)).isEqualTo(2);
        assertThat(climbStairs.climbStairs1(3)).isEqualTo(3);
        assertThat(climbStairs.climbStairs1(4)).isEqualTo(5);
        assertThat(climbStairs.climbStairs1(10)).isEqualTo(89);
        assertThat(climbStairs.climbStairs1(20)).isEqualTo(10946);
    }
    @Test
    public void should_return_success_test_climbStairs2(){
        assertThat(climbStairs.climbStairs2(1)).isEqualTo(1);
        assertThat(climbStairs.climbStairs2(2)).isEqualTo(2);
        assertThat(climbStairs.climbStairs2(3)).isEqualTo(3);
        assertThat(climbStairs.climbStairs2(4)).isEqualTo(5);
        assertThat(climbStairs.climbStairs2(10)).isEqualTo(89);
        assertThat(climbStairs.climbStairs2(20)).isEqualTo(10946);
    }
}
