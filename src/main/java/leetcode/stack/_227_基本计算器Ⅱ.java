package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * Related Topics 栈 字符串
 * <p>
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 *
 * @author Fubiao.Liu
 * @since 2021/5/31 16:44
 **/
public class _227_基本计算器Ⅱ {

    /**
     * 先计算'*'、'/'，再计算'+'、'-'
     */
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> numList = new LinkedList<>();
        Deque<Integer> operateList = new LinkedList<>();

        int lastNum = -1;
        int lastOperate = -1;
        for (char aChar : chars) {
            switch (aChar) {
                case ' ':
                    //calc(numStack, lastOperate, lastNum);
                    //lastNum = -1;
                    //lastOperate = -1;
                    break;
                case '+':
                    calc(numList, lastOperate, lastNum);
                    operateList.add(0);
                    lastNum = -1;
                    lastOperate = 0;
                    break;
                case '-':
                    calc(numList, lastOperate, lastNum);
                    operateList.add(1);
                    lastNum = -1;
                    lastOperate = 1;
                    break;
                case '*':
                    calc(numList, lastOperate, lastNum);
                    lastOperate = 2;
                    lastNum = -1;
                    break;
                case '/':
                    calc(numList, lastOperate, lastNum);
                    lastOperate = 3;
                    lastNum = -1;
                    break;
                default:
                    lastNum = (lastNum == -1 ? 0 : lastNum * 10) + Integer.parseInt(String.valueOf(aChar));
                    break;
            }
        }
        if (lastOperate != -1) {
            // numStack.push(lastNum);
            calc(numList, lastOperate, lastNum);
        } else if (lastNum != -1) {
            numList.add(lastNum);
        }
        int first = numList.removeFirst();
        while (!operateList.isEmpty()) {
            int operate = operateList.pollFirst();
            int second = numList.removeFirst();
            if (operate == 0) {
                first = first + second;
            } else if (operate == 1) {
                first = first - second;
            }
        }

        return first;
    }

    private void calc(Deque<Integer> numList, int operate, int second) {
        if (operate == -1 || numList.isEmpty()) {
            if (second != -1) {
                numList.add(second);
            }
            return;
        }
//        int first = numStack.pop();
        switch (operate) {
            case 0:
            case 1:
                numList.add(second);
                break;
            case 2:
                numList.add(numList.removeLast() * second);
                break;
            case 3:
                numList.add(numList.removeLast() / second);
                break;
            default:
                break;
        }
    }
}
