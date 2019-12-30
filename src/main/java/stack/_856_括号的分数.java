package stack;

import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * https://leetcode-cn.com/problems/score-of-parentheses
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/28
 */
public class _856_括号的分数 {
    public int scoreOfParentheses1(String S) {
        int score = 0, left = 0, current = 0;
        boolean flag = false;
        while (current < S.length()) {
            if (S.charAt(current) == '(') {
                left++;
                flag = true;
            } else {
                left--;
                if (flag) {
                    score += (1 << left);
                }
                flag = false;
            }
            current++;
        }
        return score;
    }

    /**
     * 栈
     *
     * @param S
     * @return
     */
    public int scoreOfParentheses2(String S) {
        Stack<Character> stack = new Stack<>();
        char[] arr = S.toCharArray();

        int score = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
                flag = true;
            } else {
                stack.pop();
                if (flag) {
                    score += (1 << stack.size());
                }
                flag = false;
            }
        }
        return score;
    }
}
