package leetcode.backtracking;

import java.util.*;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312"和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * <p>
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * <p>
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 提示：
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * <p>
 * Related Topics 字符串 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author Fubiao.Liu
 * @since 2021/1/7 17:47
 **/
public class _93_复原IP地址 {
    private static final int SEG_COUNT = 4;

    /**
     * 深度优先搜索：从左往右，ip的一位一位获取
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        if (s == null) {
            return result;
        }
        char[] chars = s.toCharArray();
        if (chars.length < SEG_COUNT) {
            return result;
        }
        dfs(result, new int[SEG_COUNT], chars, 0, 0);
        return result;
    }

    /**
     * ①②两处代码，只要一边打开即可
     */
    private void dfs(List<String> result, int[] segments, char[] chars, int begin, int digit) {
        if (begin == chars.length) {
            if (digit == SEG_COUNT) {
                String ip = "";
                for (int i : segments) {
                    ip = ip + i + '.';
                }
                result.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        if (digit == SEG_COUNT) {
            return;
        }
        // ①
        if (chars[begin] == '0') {
            segments[digit] = 0;
            dfs(result, segments, chars, begin + 1, digit + 1);
            return;
        }
        int i = 0;
        while (i++ <= 3 && begin + i <= chars.length) {
            int val = Integer.parseInt(new String(chars, begin, i));
            if (val > 255) {
                break;
            }
            segments[digit] = val;
            dfs(result, segments, chars, begin + i, digit + 1);
            // ②
            /*if (segment == 0) {
                break;
            }*/
        }
    }

    /**
     * ①②两处代码，只要一边打开即可
     */
    private void dfs1(List<String> result, int[] segments, char[] chars, int begin, int digit) {
        if (begin == chars.length) {
            if (digit == SEG_COUNT) {
                String ip = "";
                for (int i : segments) {
                    ip = ip + i + '.';
                }
                result.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        if (digit == SEG_COUNT) {
            return;
        }
        // ①
        if (chars[begin] == '0') {
            segments[digit] = 0;
            dfs(result, segments, chars, begin + 1, digit + 1);
            return;
        }
        int iMax = Math.min(3, chars.length - begin);
        for (int i = 1; i <= iMax; i++) {
            int segment = Integer.parseInt(new String(chars, begin, i));
            if (segment > 255) {
                break;
            }
            segments[digit] = segment;
            dfs1(result, segments, chars, begin + i, digit + 1);
            // ②
            /*if (segment == 0) {
                break;
            }*/
        }
    }

    /**
     * 三指针
     */
    public List<String> restoreIpAddresses1(String s) {
        List<String> result = new LinkedList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        char[] chars = s.toCharArray();
        int lMax = Math.min(3, chars.length - 3);
        int rMin = Math.max(chars.length - 3, 3);
        for (int l = 1; l <= lMax; l++) {
            int first = getVal(chars, 0, l);
            if (first == -1) {
                continue;
            }
            for (int r = chars.length - 1; r >= rMin; r--) {
                int range = r - l;
                if (range < 2 || range > 6) {
                    continue;
                }
                int fourth = getVal(chars, r, chars.length - r);
                if (fourth == -1) {
                    continue;
                }
                middle(result, chars, l, r, first, fourth);
            }
        }
        return result;
    }

    private void middle(List<String> result, char[] chars, int l, int r, int first, int fourth) {
        for (int i = l + 1; i < r; i++) {
            int second = getVal(chars, l, i - l);
            if (second == -1) {
                continue;
            }
            int third = getVal(chars, i, r - i);
            if (third == -1) {
                continue;
            }
            result.add(getIp(first, second, third, fourth));
        }
    }

    private int getVal(char[] chars, int begin, int count) {
        int val;
        return !(chars[begin] == '0' && count != 1) && (val = Integer.parseInt(new String(chars, begin, count))) <= 255 ? val : -1;
    }

    private String getIp(int first, int second, int third, int fourth) {
        return first + "." + second + "." + third + "." + fourth;
    }
}
