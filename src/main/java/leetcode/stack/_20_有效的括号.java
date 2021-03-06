package leetcode.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * Related Topics 栈 字符串
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author Fubiao.Liu
 * @since 2020/12/10 9:47
 **/
public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '{':
                case '[':
                    stack.push(aChar);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
            /*if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else if (aChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (aChar == '}') {
                if (stack.isEmpty() || stack.pop() != '}') {
                    return false;
                }
            } else if (aChar == ']') {
                if (stack.isEmpty() || stack.pop() != ']') {
                    return false;
                }
            }*/
        }
        return stack.isEmpty();
    }
}