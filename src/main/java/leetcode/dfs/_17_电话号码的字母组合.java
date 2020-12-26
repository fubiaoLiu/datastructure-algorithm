package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * Related Topics 深度优先搜索 递归 字符串 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * @author Fubiao.Liu
 * @since 2020/12/25 13:55
 **/
public class _17_电话号码的字母组合 {
    private static final char[][] LETTER = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        char[] chars = digits.toCharArray();
        char[] array = new char[chars.length];
        dfs(chars, 0, result, array);
        return result;
    }

    private void dfs(char[] chars, int level, List<String> result, char[] array) {
        if (level == chars.length) {
            result.add(new String(array));
            return;
        }
        char[] options = LETTER[chars[level] - '2'];
        for (char option : options) {
            array[level] = option;
            dfs(chars, level + 1, result, array);
        }
    }
}