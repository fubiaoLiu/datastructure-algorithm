package leetcode.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Assertions.assertListEqualsDisorder;

public class _22_Test {
    _22_括号生成 obj = new _22_括号生成();

    @Test
    public void test1() {
        int n = 3;
        String[] expectedValues = {"((()))", "(()())", "(())()", "()(())", "()()()"};
        List<String> expected = new ArrayList<>(Arrays.asList(expectedValues));
        assertListEqualsDisorder(expected, obj.generateParenthesis(n));
    }
}