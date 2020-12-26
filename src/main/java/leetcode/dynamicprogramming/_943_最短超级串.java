package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 给定一个字符串数组 A，找到以 A 中每个字符串作为子字符串的最短字符串。
 * 我们可以假设 A 中没有字符串是 A 中另一个字符串的子字符串。
 * <p>
 * 示例 1：
 * 输入：["alex","loves","leetcode"]
 * 输出："alexlovesleetcode"
 * 解释："alex"，"loves"，"leetcode" 的所有排列都会被接受。
 * <p>
 * 示例 2：
 * 输入：["catg","ctaagt","gcta","ttca","atgcatc"]
 * 输出："gctaagttcatgcatc"
 * <p>
 * 提示：
 * 1 <= A.length <= 12
 * 1 <= A[i].length <= 20
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/find-the-shortest-superstring
 *
 * @author Fubiao.Liu
 * @since 2020/12/24 20:26
 **/
public class _943_最短超级串 {
    public String shortestSuperstring(String[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        if (A.length == 1) {
            return A[0];
        }
        // TODO 这题太难了，不是人看的题解
        return null;
    }

    /**
     * 题解：DP
     * 时间复杂度：O(N^2 * (2^N + W))，其中 N 是字符串的数目，W 是字符串的最大长度。
     * 空间复杂度：O(N * (2^N + W))
     */
    public String shortestSuperstringAnswer(String[] A) {
        int n = A.length;

        // Populate overlaps
        // 计算两两字符串间重叠字符的长度
        // 预先计算出所有的 overlap(A[i], A[j])
        int[][] overlaps = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    int m = Math.min(A[i].length(), A[j].length());
                    for (int k = m; k >= 0; --k) {
                        if (A[i].endsWith(A[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }

        // dp[mask][i] = most overlap with mask, ending with ith element
        // 使用动态规划计算出所有的 dp(mask, i)，并记录每个状态从哪个状态转移得来，记为 parent
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int mask = 0; mask < (1 << n); ++mask) {
            Arrays.fill(parent[mask], -1);

            for (int bit = 0; bit < n; ++bit) {
                if (((mask >> bit) & 1) > 0) {
                    // Let's try to find dp[mask][bit].  Previously, we had
                    // a collection of items represented by pmask.
                    int pmask = mask ^ (1 << bit);
                    if (pmask == 0) {
                        continue;
                    }
                    for (int i = 0; i < n; ++i) {
                        if (((pmask >> i) & 1) > 0) {
                            // For each bit i in pmask, calculate the value
                            // if we ended with word i, then added word 'bit'.
                            int val = dp[pmask][i] + overlaps[i][bit];
                            if (val > dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            }
        }

        // # Answer will have length sum(len(A[i]) for i) - max(dp[-1])
        // Reconstruct answer, first as a sequence 'perm' representing
        // the indices of each word from left to right.
        // 通过 parent 还原这个字符串
        int[] perm = new int[n];
        boolean[] seen = new boolean[n];
        int t = 0;
        int mask = (1 << n) - 1;

        // p: the last element of perm (last word written left to right)
        int p = 0;
        for (int j = 0; j < n; ++j) {
            if (dp[(1 << n) - 1][j] > dp[(1 << n) - 1][p]) {
                p = j;
            }
        }

        // Follow parents down backwards path that retains maximum overlap
        while (p != -1) {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= 1 << p;
            p = p2;
        }

        // Reverse perm
        for (int i = 0; i < t / 2; ++i) {
            int v = perm[i];
            perm[i] = perm[t - 1 - i];
            perm[t - 1 - i] = v;
        }

        // Fill in remaining words not yet added
        for (int i = 0; i < n; ++i) {
            if (!seen[i]) {
                perm[t++] = i;
            }
        }

        // Reconstruct final answer given perm
        StringBuilder ans = new StringBuilder(A[perm[0]]);
        for (int i = 1; i < n; ++i) {
            int overlap = overlaps[perm[i - 1]][perm[i]];
            ans.append(A[perm[i]].substring(overlap));
        }

        return ans.toString();
    }
}