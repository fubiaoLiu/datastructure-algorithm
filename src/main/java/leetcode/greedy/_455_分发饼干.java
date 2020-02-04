package leetcode.greedy;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * https://leetcode-cn.com/problems/assign-cookies
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/4
 */
public class _455_分发饼干 {

    /**
     * @param g 小孩子的胃口值
     * @param s 饼干尺寸
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int gi = g.length - 1;
        for (int si = s.length - 1; si >= 0; si--) {
            for (; gi >= 0; gi--) {
                if (s[si] >= g[gi]) {
                    result++;
                    gi--;
                    break;
                }
            }
        }
        return result;
    }

    public int findContentChildren1(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
            }
            si++;
        }

        return gi;
    }
}
