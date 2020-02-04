package algorithm.recursion;

/**
 * @description: 汉诺塔
 * 把 A 的 n 个盘子移动到 C（盘子编号是 [1, n] ）
 * 每次只能移动1个盘子
 * 大盘子只能放在小盘子下面
 * @author: FuBiaoLiu
 * @date: 2020/2/3
 */
public class Hanoi {
    /**
     * 递归
     * 当n == 1时，直接从p1移动到p3
     * 当n > 1时，将 n - 1 个移动到p2，再将第 n 个移动到p3，接着移动剩下的 n - 1 个
     *
     * @param n
     * @param p1 A
     * @param p2 B
     * @param p3 C
     */
    public void hanoi(int n, String p1, String p2, String p3) {
        if (n <= 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    private void move(int n, String from, String to) {
        if (n < 1) {
            return;
        }
        System.out.println(n + "号盘子：" + from + "->" + to);
    }
}
