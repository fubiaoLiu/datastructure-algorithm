package algorithm.sequence;

/**
 * 蛮力算法
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/8
 */
public class BruteForce {
    /**
     * while代替for循环
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

        int ti = 0, pi = 0, end = tLen - pLen;
        while (ti <= end && pi < pLen) {
            if (text.charAt(ti + pi) != pattern.charAt(pi)) {
                ti++;
                pi = 0;
            } else {
                pi++;
            }
        }
        return ti > end ? -1 : ti;
    }

    /**
     * 蛮力优化 - 减少无效比较
     */
    public int indexOf2(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }
        int tLen = text.length();
        int pLen = pattern.length();
        if (tLen == 0 || pLen == 0 || tLen < pLen) {
            return -1;
        }

        int end = tLen - pLen;
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j < pLen; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                } else if (j == pLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 蛮力
     */
    public int indexOf1(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }
        int tLen = text.length();
        int pLen = pattern.length();
        if (tLen == 0 || pLen == 0 || tLen < pLen) {
            return -1;
        }

        for (int i = 0; i < tLen; i++) {
            for (int j = 0; j < pLen && i + j < tLen; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                } else if (j == pLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
