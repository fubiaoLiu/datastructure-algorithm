package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个会议时间安排的数组，每个会议时间都包括开始和结束时间[[s1,e1][s2,e2]...](si < ei).
 * 请你判断一个人能否参加这里面的全部会议。
 * <p>
 * 实例 1：
 * 输入：[[0,30],[5,10],[15,20]]
 * 输出：false
 * <p>
 * 实例 2：
 * 输入：[[7,10],[2,4]]
 * 输出：true
 * <p>
 * Related Topics 排序
 * <p>
 * https://leetcode-cn.com/problems/meeting-rooms
 *
 * @author Fubiao.Liu
 * @since 2021/2/4 17:49
 **/
public class _252_会议室 {
    /**
     * 按开始时间排序，看后一个要参加会议的开始时间是否晚于前一个会议的结束时间
     */
    public boolean meetingRoom(int[][] nums) {
        if (nums == null) {
            return true;
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][1] < nums[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
