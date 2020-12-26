package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * <p>
 * Related Topics 字符串 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author Fubiao.Liu
 * @since 2020/12/25 15:44
 **/
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        char[] array = new char[n << 1];
        dfs(result, array, n, n);
        return result;
    }

    private void dfs(List<String> result, char[] array, int left, int right) {
        if (right == 0) {
            result.add(new String(array));
            return;
        }
        int index = array.length - left - right;
        if (left > 0) {
            array[index] = '(';
            dfs(result, array, left - 1, right);
        }
        if (left < right) {
            array[index] = ')';
            dfs(result, array, left, right - 1);
        }
    }
}