package leetcode.characterstring;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例 2：
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 示例 4：
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * <p>
 * 示例 5：
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * 进阶：
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * Related Topics 字符串
 * <p>
 * https://leetcode-cn.com/problems/reverse-words-in-a-string
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 8:58
 **/
public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int cur = 0;
        boolean lastIsBlank = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                lastIsBlank = false;
            } else if (!lastIsBlank) {
                chars[cur++] = ' ';
                lastIsBlank = true;
            }
        }
        int len = lastIsBlank ? (cur - 1) : cur;
        if (len <= 0) {
            return "";
        }
        recovery(chars, 0, len);
        int begin = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                recovery(chars, begin, i);
                begin = i + 1;
            }
        }
        recovery(chars, begin, len);
        return new String(chars, 0, len);
    }

    private void recovery(char[] chars, int begin, int end) {
        while (begin < --end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
        }
    }
}