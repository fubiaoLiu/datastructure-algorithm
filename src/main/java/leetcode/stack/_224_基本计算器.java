package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

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
    public int calculate(String s) {
        Deque<Object> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Object last = stack.pop();
            // if (Integer.parseInt(last))
            //leetcode.stack.
        }
        return 0;
    }

    /*private String[] infixConvertPostfixExp(String s) {
        Deque<String> leetcode.stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[fast])) {
                tmp.append(chars[fast]);
                fast++;
            } else {
                leetcode.stack.push(tmp.toString());
                tmp.delete(0, tmp.length());
                fast++;
                slow = fast;
            }
        }
    }*/

    public static void main(String[] args) {
        System.out.println('1' == 49);
    }
}
