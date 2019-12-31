package tree;

/**
 * 给定一个整数n，求以1...n为节点组成的二叉搜索树有多少种？
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/submissions/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/30
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
