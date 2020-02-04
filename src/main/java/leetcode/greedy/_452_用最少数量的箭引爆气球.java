package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 * 开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
 * 可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/4
 */
public class _452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparing(a -> a[0]));
        int result = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int x1 = points[i][0];
            int x2 = points[i][1];
            if (x1 <= end && x2 >= end) {
                continue;
            }
            if (x1 > end) {
                result++;
            }
            end = x2;
        }
        return result;
    }

    public int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparing(a -> a[0]));
        int result = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int iend = points[i][1];
            if (points[i][0] > end) {
                result++;
                end = iend;
            } else if (iend < end) {
                end = iend;
            }
        }
        return result;
    }
}
