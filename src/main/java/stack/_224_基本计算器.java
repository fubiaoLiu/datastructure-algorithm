package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格。
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/28
 */
public class _224_基本计算器 {
    public int calculate(String s) {
        Deque<Object> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Object last = stack.pop();
            // if (Integer.parseInt(last))
            //stack.
        }
        return 0;
    }

    /*private String[] infixConvertPostfixExp(String s) {
        Deque<String> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[fast])) {
                tmp.append(chars[fast]);
                fast++;
            } else {
                stack.push(tmp.toString());
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
