package leetcode.tree;

/**
 * 给定一个整数n，求以1...n为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * <p>
 *  Related Topics 树 动态规划
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/submissions/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/30
 */
public class _96_不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += num[i - j - 1] * num[j];
            }
            num[i] = tmp;
        }
        return num[n];
    }
}
