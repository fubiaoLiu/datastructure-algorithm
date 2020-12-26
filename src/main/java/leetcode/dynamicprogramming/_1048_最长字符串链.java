package leetcode.dynamicprogramming;

import java.util.*;

/**
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。
 * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac
 * " 的前身。
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_
 * 2 是 word_3 的前身，依此类推。
 * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 * <p>
 * 示例：
 * 输入：["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 "a","ba","bda","bdca"。
 * <p>
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 * <p>
 * Related Topics 哈希表 动态规划
 * <p>
 * https://leetcode-cn.com/problems/longest-string-chain
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 17:13
 **/
public class _1048_最长字符串链 {
    private int max = 1;

    /**
     * DFS
     */
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int minLength, maxLength;
        minLength = maxLength = words[0].length();
        // key为字符串长度，value为字符串集合
        Map<Integer, Set<String>> map = new HashMap<>();
        // 初始化map
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            map.computeIfAbsent(length, s -> new HashSet<>()).add(words[i]);
            minLength = Math.min(minLength, length);
            maxLength = Math.max(maxLength, length);
        }
        for (int len = minLength; len <= maxLength; len++) {
            Set<String> set = map.get(len);
            if (set == null || maxLength + 1 - len <= max) {
                continue;
            }
            for (String word : set) {
                findSuccessor(map, word, len);
            }
        }
        return max;
    }

    /**
     * 找到下一个节点
     *
     * @param map  map
     * @param word 当前字符串
     * @param len  当前字符串长度
     */
    private void findSuccessor(Map<Integer, Set<String>> map, String word, int len) {
        max = Math.max(max, word.length() + 1 - len);
        Set<String> set = map.get(word.length() + 1);
        if (set == null || set.isEmpty()) {
            return;
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String successor = iterator.next();
            if (isSuccessor(word, successor)) {
                findSuccessor(map, successor, len);
                iterator.remove();
            }
        }
    }

    /**
     * @return successorWord是否是word的后身
     */
    private boolean isSuccessor(String word, String successorWord) {
        char[] wordChars = word.toCharArray();
        char[] sWordChars = successorWord.toCharArray();
        int wordLen = wordChars.length, sWordLen = sWordChars.length;
        if (sWordLen - wordLen != 1) {
            return false;
        }
        int i = 0, j = 0;
        while (i < wordLen && j < sWordLen) {
            if (wordChars[i] == sWordChars[j]) {
                i++;
            }
            j++;
        }
        return i == wordLen;
    }


    int res = 0;

    /**
     * 题解3: DFS
     */
    public int longestStrChainDFS(String[] words) {
        // 最小字符长度，最大字符长度
        int min = 0, max = 16;
        // K为字符长度，Set为该字符长度的word集合
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word.length(), new HashSet<>());
            map.get(word.length()).add(word);
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }
        for (int len = min; len <= max; len++) {
            Set<String> curSet = map.get(len);
            // 当set没有值时，无需遍历
            if (curSet == null) {
                continue;
            }
            // 最大长度+1-当前的长度<=res，res更加符合题意
            if ((max + 1 - len <= res)) {
                continue;
            }
            for (String cur : curSet) {
                findNext(map, len, cur);
            }
        }
        return res;
    }

    /**
     * @param map
     * @param len      当前字符的长度
     * @param levelStr 当前字符
     */
    private void findNext(Map<Integer, Set<String>> map, int len, String levelStr) {
        // 记录结果集
        res = Math.max(res, levelStr.length() + 1 - len);
        Set<String> curSet = map.get(levelStr.length() + 1);
        // 退出条件
        if (curSet == null) {
            return;
        }
        Iterator<String> it = curSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (isPredecessor(levelStr, next)) {
                findNext(map, len, next);
                it.remove();
            }
        }
    }

    /**
     * 题解2: 动态规划改进版
     */
    public int longestStrChainDp2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] arr = new int[17];
        Arrays.fill(arr, -1);
        int n = words.length;
        for (int i = 0; i < n; i++) {
            arr[words[i].length()] = i;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int target = words[i].length() - 1;
            int index = arr[target];
            while (index >= 0 && words[index].length() == target) {
                if (isPredecessor(words[index], words[i])) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                }
                index--;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 题解1: 动态规划
     * 时间复杂度：O(k * n^2) => O(n^2)
     * n: words的长度
     * k: word的长度（根据题意：1 <= k <= 16）
     */
    public int longestStrChainDp1(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            String a = words[i];
            for (int j = i + 1; j < n; j++) {
                String b = words[j];
                if (isPredecessor(a, b)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(dp[j], res);
                }
            }
        }
        return res + 1;
    }

    /**
     * 判断a是否是b的前身 是返回true 如 "bda" 是"bdca"的前身
     */
    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        if ((m + 1) != n) {
            return false;
        }
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}