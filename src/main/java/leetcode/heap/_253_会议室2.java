package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个会议时间安排的数组，每个会议时间都包括开始和结束时间[[s1,e1][s2,e2]...](si < ei).
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算最少需要多少间会议室，才能满足这些会议安排。
 * <p>
 * 实例 1：
 * 输入：[[0,30],[5,10],[15,20]]
 * 输出：2
 * <p>
 * 实例 2：
 * 输入：[[7,10],[2,4]]
 * 输出：1
 * <p>
 * Related Topics 堆
 * <p>
 * https://leetcode-cn.com/problems/meeting-rooms-ii
 *
 * @author Fubiao.Liu
 * @since 2021/2/4 17:49
 **/
public class _253_会议室2 {
    /**
     * 分开排序
     */
    public int meetingRoom(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] beginTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            beginTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(beginTimes);
        Arrays.sort(endTimes);

        int rooms = 0, end = 0;
        for (int beginTime : beginTimes) {
            if (beginTime >= endTimes[end]) {
                // 能重复利用会议室
                end++;
            } else {
                // 需要新开一个会议室
                rooms++;
            }
        }
        return rooms;
    }

    /**
     * 用一个小顶堆，按开始时间顺序，以结束时间为分值，放入小顶堆。
     * 如果堆顶的结束时间小于当前开始时间，则表示会议室可以重复利用。否则需要增加一个会议室。
     * 最后返回堆大小。
     */
    public int meetingRoom1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照会议的开始时间，从小到大排序  nlogn
        Arrays.sort(intervals, Comparator.comparing(m -> m[0]));

        // 创建一个最小堆（存放会议的结束时间）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号会议的结束时间
        heap.offer(intervals[0][1]);

        // 堆顶的含义：目前占用的会议室中最早结束的时间
        // nlogn
        for (int i = 1; i < intervals.length; i++) {
            if (heap.peek() <= intervals[i][0]) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
        }
        return heap.size();
    }
}
