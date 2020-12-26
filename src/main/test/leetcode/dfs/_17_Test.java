package leetcode.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Assertions.assertListEqualsDisorder;

public class _17_Test {
    _17_电话号码的字母组合 obj = new _17_电话号码的字母组合();

    @Test
    public void test1() {
        String digits = "23";
        String[] expectedValues = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        List<String> expected = new ArrayList<>(Arrays.asList(expectedValues));
        assertListEqualsDisorder(expected, obj.letterCombinations(digits));
    }
}