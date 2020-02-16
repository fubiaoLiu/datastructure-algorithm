package leetcode.dynamicprogramming;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/11
 */
public class _5_最长回文子串 {
    /**
     * 优化 - 使用一维数组代替二维数组
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        int max = 1;
        int maxStart = 0;
        for (int start = len - 1; start >= 0; start--) {
            for (int end = len - 1; end > start; end--) {
                // 如果首尾不相等 或者 （除首尾之外不是回文串并且首尾不相邻），则不是回文串
                if (chars[start] != chars[end] || (start != end - 1 && dp[end - 1] == 0)) {
                    dp[end] = 0;
                    continue;
                }
                dp[end] = dp[end - 1] + 2;
                if (dp[end] > max) {
                    max = dp[end];
                    maxStart = start;
                }
            }
            dp[start] = 1;
        }

        return s.substring(maxStart, maxStart + max);
    }

    /**
     * 第一版
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        int max = 1;
        int maxStart = 0;
        for (int start = len - 1; start >= 0; start--) {
            dp[start][start] = 1;
            for (int end = start + 1; end < len; end++) {
                if (chars[start] == chars[end] && (start == end - 1 || dp[start + 1][end - 1] > 0)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                    if (dp[start][end] > max) {
                        max = dp[start][end];
                        maxStart = start;
                    }
                }
            }
        }

        return s.substring(maxStart, maxStart + max);
    }

    /**
     * 未通过测试
     *
     * @param s
     * @return
     */
    @Deprecated
    public String longestPalindromeDeprecated(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] lens = new int[len];
        int[] begins = new int[len];
        int max = 0;
        lens[0] = 1;
        begins[0] = 0;
        for (int i = 1; i < len; i++) {
            if (lens[i - 1] > 1) {
                int preBegin = begins[i - 1];
                if (preBegin > 0 && chars[preBegin - 1] == chars[i]) {
                    begins[i] = preBegin - 1;
                    lens[i] = lens[i - 1] + 2;
                } else {
                    boolean flag = true;
                    for (int j = preBegin; j <= i; j++) {
                        if (chars[i] != chars[j]) {
                            lens[i] = 1;
                            begins[i] = i;
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        begins[i] = begins[i - 1];
                        lens[i] = lens[i - 1] + 1;
                    } else if (chars[i] == chars[i - 1]) {
                        lens[i] = 2;
                        begins[i] = i - 1;
                    } else if (chars[i] == chars[i - 2]) {
                        lens[i] = 3;
                        begins[i] = i - 2;
                    }
                }
                if (lens[max] < lens[i]) {
                    max = i;
                }
                continue;
            }
            if (chars[i] == chars[i - 1]) {
                lens[i] = 2;
                begins[i] = i - 1;
            } else if (i - 2 >= 0 && chars[i] == chars[i - 2]) {
                lens[i] = 3;
                begins[i] = i - 2;
            } else {
                lens[i] = 1;
                begins[i] = i;
            }
            if (lens[max] < lens[i]) {
                max = i;
            }
        }

        return s.substring(begins[max], begins[max] + lens[max]);
    }
}
