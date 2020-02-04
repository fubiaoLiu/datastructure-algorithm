package algorithm.recursion;

import org.junit.jupiter.api.Test;

public class HanoiTest {
    Hanoi hanoi = new Hanoi();

    @Test
    public void should_return_true() {
        hanoi.hanoi(3, "A", "B", "C");
    }
}
