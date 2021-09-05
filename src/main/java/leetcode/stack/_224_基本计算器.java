package leetcode.stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。
 * <p>
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * <p>
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * <p>
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * Related Topics 栈 数学
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/28
 */
public class _224_基本计算器 {
    /**
     * 递归
     * 扫描到左括号就进入下一个递归，扫描到右括号就退出当前调用，返回当前子表达式的计算结果
     *
     * @param s 表达式字符串
     * @return 计算结果
     */
    public int calculate(String s) {
        return calculate(s.toCharArray(), 0)[0];
    }

    public int[] calculate(char[] chars, int start) {
        // result[0]: 子表达式的计算结果
        // result[1]: 子表达式的结束索引
        int[] result = new int[2];
        char operate = ' ';
        int lathNumber = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            int current = chars[i] - '0';
            if (chars[i] == '(') {
                int[] subResult = calculate(chars, i + 1);
                lathNumber = subResult[0];
                i = subResult[1];
            } else if (chars[i] == ')') {
                result[1] = i;
                return result;
            } else if (chars[i] == '-' || chars[i] == '+') {
                operate = chars[i];
                lathNumber = 0;
                continue;
            } else {
                lathNumber = lathNumber * 10 + current;
                if (i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    // 如果当前是数字，下一个也是数字，直接进入下一个循环，这两个数字应该组装为同一个数字
                    continue;
                }
            }
            if (operate == ' ') {
                result[0] = lathNumber;
            } else if (operate == '-') {
                result[0] -= lathNumber;
                operate = ' ';
            } else if (operate == '+') {
                result[0] += lathNumber;
                operate = ' ';
            }
        }
        return result;
    }

    /**
     * lc耗时最短范例
     * @param s 表达式字符串
     * @return 计算结果
     */
    public int calculate1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return dfs(s.toCharArray(), 0)[0];
    }

    private int[] dfs(char[] chars, int index) {
        if (index >= chars.length) {
            return new int[]{0, index};
        }

        int result = 0;
        int lastNumber = 0;
        int lastFlag = 1;
        int i = index;
        for (; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    int[] innerResult = dfs(chars, i + 1);
                    result += lastFlag * innerResult[0];
                    i = innerResult[1];
                    break;
                case ')':
                    result += lastFlag * lastNumber;
                    return new int[]{result, i};
                case '+':
                    result += lastFlag * lastNumber;
                    lastNumber = 0;
                    lastFlag = 1;
                    break;
                case '-':
                    result += lastFlag * lastNumber;
                    lastNumber = 0;
                    lastFlag = -1;
                    break;
                case ' ':
                    break;
                default:
                    lastNumber = lastNumber * 10 + (chars[i] - '0');
                    break;
            }
        }
        result += lastFlag * lastNumber;
        return new int[]{result, i};
    }
}
