package algorithm.sequence;

/**
 * KMP(Knuth–Morris–Pratt)
 * 最好时间复杂度：O(m)
 * 最坏时间复杂度：O(n + m)
 * 空间复杂度：O(m)
 *
 * @author FuBiaoLiu
 * @since 2020/2/8
 */
public class KMP {
    /**
     * KMP主逻辑，与蛮力算法类似
     * 最好时间复杂度：O(m)
     * 最坏时间复杂度：O(n)，不超过O(2n)
     */
    public int indexOf(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }
        int tLen = text.length();
        int pLen = pattern.length();
        if (tLen == 0 || pLen == 0 || tLen < pLen) {
            return -1;
        }
        int[] next = next(pattern);
        int ti = 0, pi = 0, end = tLen - pLen;
        while (ti <= end && pi < pLen) {
            if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return pi == pLen ? -1 : ti - pi;
    }

    /**
     * 根据模式串构建next表 - 优化: 以防特殊情况下退化成蛮力算法
     * 时间复杂度：O(m)，m为模式串长度
     */
    private int[] next(String pattern) {
        char[] chars = pattern.toCharArray();
        int len = chars.length;
        int[] next = new int[len];
        int n = next[0] = -1;
        int i = 0;
        int iMax = len - 1;
        while (i < iMax) {
            if (n < 0 || chars[i] == chars[n]) {
                i++;
                n++;
                if (chars[i] == chars[n]) {
                    next[i] = next[n];
                } else {
                    next[i] = n;
                }
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }

    /**
     * 根据模式串构建next表
     */
    private int[] next1(String pattern) {
        char[] chars = pattern.toCharArray();
        int len = chars.length;
        int[] next = new int[len];
        int n = next[0] = -1;
        int i = 0;
        int iMax = len - 1;
        while (i < iMax) {
            if (n < 0 || chars[i] == chars[n]) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
