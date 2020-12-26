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
 * Related Topics 字符串 动态规划
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 * @author FuBiaoLiu
 * @since 2020/2/11
 */
public class _5_最长回文子串 {
    /**
     * 优化 - 使用一维数组代替二维数组
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
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
        if (s == null || s.length() <= 1) {
            return s;
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
        if (s == null || s.length() <= 1) {
            return s;
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

    // ------------------第三季练习-------------------

    /**
     * (Manacher)马拉车
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] oldCs = s.toCharArray();
        char[] chars = preprocess(oldCs);
        int[] m = new int[chars.length];
        int maxIdx = 1;
        int r = 1, c = 0, li;
        int lastIdx = chars.length - 3;
        for (int i = 2; i <= lastIdx; i++) {
            if (r > i) {
                li = (c << 1) - i;
                m[i] = (i + m[li] <= r) ? m[li] : (r - i);
            }
            while (chars[i - m[i] - 1] == chars[i + m[i] + 1]) {
                m[i]++;
            }
            if (m[i] > m[maxIdx]) {
                maxIdx = i;
            }
            if (i + m[i] > r) {
                r = i + m[i];
                c = i;
            }
        }

        int begin = (maxIdx - m[maxIdx]) >> 1;
        return new String(oldCs, begin, m[maxIdx]);
    }

    public char[] preprocess(char[] oldCs) {
        char[] chars = new char[(oldCs.length << 1) + 3];
        chars[0] = '^';
        chars[1] = '#';
        for (int i = 0; i < oldCs.length; i++) {
            int idx = (i << 1) + 2;
            chars[idx] = oldCs[i];
            chars[idx + 1] = '#';
        }
        chars[chars.length - 1] = '*';
        return chars;
    }

    /**
     * 扩展中心2
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public String longestPalindromeEx2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        int i = 0;
        while (i < chars.length) {
            int l = i - 1;
            int r = i;
            while (++r < chars.length && chars[r] == chars[i]) {
            }
            i = r;
            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            int len = r - l - 1;
            if (len > maxLen) {
                maxLen = len;
                begin = l + 1;
            }
        }
        return new String(chars, begin, maxLen);
    }

    /**
     * 扩展中心
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public String longestPalindromeEx1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        for (int i = 1; i < chars.length; i++) {
            int len1 = palindrome(chars, i - 1, i + 1);
            int len2 = palindrome(chars, i, i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
                begin = i - ((len1 - 1) >> 1);
            }
        }
        if (maxLen < 2 && chars[0] == chars[1]) {
            maxLen = 2;
            begin = 0;
        }

        return new String(chars, begin, maxLen);
    }

    /**
     * @return 从chars数组中l, r开始向两边扩展扫描到的最长回文子串的长度
     */
    private int palindrome(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 一维数组
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public String longestPalindromeDp2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length];
        int max = 1;
        int begin = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i] = true;
            for (int j = chars.length - 1; j > i; j--) {
                int len = j - i + 1;
                dp[j] = chars[i] == chars[j] && (len == 2 || dp[j - 1]);
                if (dp[j] && len > max) {
                    max = len;
                    begin = i;
                }
            }
        }
        return new String(chars, begin, max);
    }

    /**
     * 二维数组
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    public String longestPalindromeDp1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int max = 1;
        int begin = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < chars.length; j++) {
                int len = j - i + 1;
                dp[i][j] = chars[i] == chars[j] && (j - i == 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > max) {
                    max = len;
                    begin = i;
                }
            }
        }
        return new String(chars, begin, max);
    }
}
