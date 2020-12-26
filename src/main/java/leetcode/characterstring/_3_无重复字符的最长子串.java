package leetcode.characterstring;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author liufb
 * @since 2020/8/14 14:19
 **/
public class _3_无重复字符的最长子串 {
    /**
     * 注释部分代码，用于打印最长子串内容
     *
     * @param s 母串
     * @return 最长子串长度
     */
    public int longOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] lastIndexArray = new int[26];
        char[] chars = s.toLowerCase().toCharArray();
        int max = 0;
//        int maxStart = 1;
        int start = 1;
        int ascii;
        for (int i = 1; i <= chars.length; i++) {
            ascii = chars[i - 1] - 97;
            int lastIndex = lastIndexArray[ascii];
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }
//            if (max < i - start + 1) {
//                maxStart = start;
//            }
            max = Math.max(max, i - start + 1);
            lastIndexArray[ascii] = i;
        }
//        System.out.println(text.substring(maxStart - 1, maxStart + max - 1));
        return max;
    }

    public int longOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] lastIndexes = new int[128];
        for (int i = 0; i < lastIndexes.length; i++) {
            lastIndexes[i] = -1;
        }
        char[] chars = s.toCharArray();
        lastIndexes[chars[0]] = 0;
        int max = 1;
        int begin = 0;
        int ascii, lastIndex;
        for (int i = 1; i < chars.length; i++) {
            ascii = chars[i];
            lastIndex = lastIndexes[ascii];
            if (lastIndex >= begin) {
                begin = lastIndex + 1;
            }
            lastIndexes[ascii] = i;
            max = Math.max(i - begin + 1, max);
        }
        return max;
    }
}
