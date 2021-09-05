package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
 * 回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * Related Topics 排序 数组
 * <p>
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author Fubiao.Liu
 * @since 2021/5/31 11:26
 **/
public class _56_合并数组 {
    /**
     * 先按开始时间排序，再合并
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                result.add(current);
            }
        }
        return result.toArray(new int[result.size() - 1][2]);
    }
}
