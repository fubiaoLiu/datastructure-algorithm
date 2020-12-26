package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static utils.Assertions.assertListEqualsDisorder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _51_Test {
    _51_N皇后 obj = new _51_N皇后();

    @Test
    public void test1() {
        int n = 4;
        String[] expectedPlan1 = {".Q..", "...Q", "Q...", "..Q."};
        String[] expectedPlan2 = {"..Q.", "Q...", "...Q", ".Q.."};
        List<List<String>> actual = obj.solveNQueens(n);
        assertEquals(2, actual.size());
        assertListEqualsDisorder(Arrays.asList(expectedPlan1), actual.get(0));
        assertListEqualsDisorder(Arrays.asList(expectedPlan2), actual.get(1));
    }

    @Test
    public void test2() {
        int n = 1;
        String[] expectedPlan = {"Q"};
        List<List<String>> actual = obj.solveNQueens(n);
        assertEquals(1, actual.size());
        assertListEqualsDisorder(Arrays.asList(expectedPlan), actual.get(0));
    }
}