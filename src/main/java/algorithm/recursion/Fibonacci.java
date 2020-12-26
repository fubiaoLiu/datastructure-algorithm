package algorithm.recursion;

/**
 * @description: 斐波那契数列
 * @author FuBiaoLiu
 * @since 2020/2/3
 */
public class Fibonacci {
    /**
     * 递归
     *
     * @param n 第 n 个数
     * @return
     */
    public int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }


    /**
     * 优化1 - 记忆化(减少重复计算)
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib2(n, array);
    }

    private int fib2(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib2(n - 1, array) + fib2(n - 2, array);
        }
        return array[n];
    }

    /**
     * 优化2 - 去除递归调用(减少函数调用开销)
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 优化3 - 使用滚动数组(减小空间复杂度)
     *
     * @param n
     * @return
     */
    public int fib4(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[0] + array[1];
        }
        return array[n % 2];
    }

    /**
     * 优化4 - 位运算取代模运算(提高运算效率)
     *
     * @param n
     * @return
     */
    public int fib5(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[0] + array[1];
        }
        return array[n & 1];
    }

    /**
     * 优化5 - 使用两个变量代替数组
     *
     * @param n
     * @return
     */
    public int fib6(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    /**
     * 优化6 - 使用特征方程(线性代数) - 至少可低至O(logn)
     *
     * @param n
     * @return
     */
    public int fib7(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    /**
     * 尾递归
     *
     * @param n
     * @return
     */
    public int fib8(int n) {
        return fib8(n, 1, 1);
    }

    public int fib8(int n, int first, int second) {
        if (n <= 2) {
            return second;
        }
        return fib8(n - 1, second, first + second);
    }
}
