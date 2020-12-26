package leetcode.stack;

import java.util.Stack;

/**
 * 请根据每日气温列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * Related Topics 栈 哈希表
 * <p>
 * https://leetcode-cn.com/problems/daily-temperatures
 *
 * @author Fubiao.Liu
 * @since 2020/12/9 17:46
 **/
public class _739_每日温度 {
    /**
     * i用来扫描所有的元素，从右往左扫描（ 逐渐递减），一开始i指向倒数第2个元素
     * 对于每一个i，一开始令 j = i + 1
     * 1、如果T[i] < T[j]，values[i] = values[j] + j - i，i--
     * 2、如果T[i] == T[j]，values[i] = values[j]，i--
     * 3、如果T[i] > T[j]，j = j + values[j]，回到1
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }
        int[] values = new int[T.length];
        values[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {
                    values[i] = 0;
                    break;
                }
                j = j + values[j];
            }
        }
        return values;
    }

    /**
     * i用来扫描所有的元素，从右往左扫描（ 逐渐递减），一开始i指向倒数第2个元素
     * 对于每一个i，一开始令 j = i + 1
     * 1、如果T[i] < T[j]，values[i] = values[j] + j - i，i--
     * 2、如果T[i] == T[j]，values[i] = values[j]，i--
     * 3、如果T[i] > T[j]，j = j + values[j]，回到1
     */
    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }
        int[] values = new int[T.length];
        values[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {
                    values[i] = 0;
                    break;
                } else if (T[i] == T[j]) {
                    values[i] = values[j] + j - i;
                    break;
                }
                j = j + values[j];
            }
        }
        return values;
    }

    /**
     * 基于栈实现
     */
    public int[] dailyTemperaturesStack(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer day = stack.pop();
                result[day] = i - day;
            }
            stack.push(i);
        }
        return result;
    }
}