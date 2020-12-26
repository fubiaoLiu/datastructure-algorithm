package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * <p>
 * 示例 1：
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 * <p>
 * 示例 2：
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 * <p>
 * 示例 3：
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 * <p>
 * 提示：
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
 * 1 <= startTime[i] < endTime[i] <= 10^9
 * 1 <= profit[i] <= 10^4
 * <p>
 * Related Topics 排序 二分查找 动态规划
 * <p>
 * https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 *
 * @author Fubiao.Liu
 * @since 2020/12/24 17:35
 **/
public class _1235_规划兼职工作 {

    /**
     * DP
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        // 排序
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));
        int[] dp = new int[jobs.length];
        dp[0] = jobs[0][2];
        for (int i = 1; i < jobs.length; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    dp[i] = Math.max(dp[j] + jobs[i][2], dp[i]);
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 递归：开始时间、结束时间、报酬封装到二维数组中排序
     * 超出时间限制
     */
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        // 排序
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        return jobScheduling2(jobs, 0, 0);
    }

    private int jobScheduling2(int[][] jobs, int lastTime, int n) {
        while (n < jobs.length && jobs[n][0] < lastTime) {
            n++;
        }
        if (n == jobs.length) {
            return 0;
        }
        int use = jobScheduling2(jobs, jobs[n][1], n + 1) + jobs[n][2];
        int unuse = jobScheduling2(jobs, lastTime, n + 1);
        return Math.max(use, unuse);
    }

    /**
     * 递归：封装到Job对象排序
     * 超出时间限制
     */
    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || startTime.length == 0) {
            return 0;
        }
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.startTime));
        return jobScheduling1(jobs, 0, 0);
    }

    private int jobScheduling1(Job[] jobs, int lastTime, int n) {
        while (n < jobs.length && jobs[n].startTime < lastTime) {
            n++;
        }
        if (n == jobs.length) {
            return 0;
        }
        int use = jobScheduling1(jobs, jobs[n].endTime, n + 1) + jobs[n].profit;
        int unuse = jobScheduling1(jobs, lastTime, n + 1);
        return Math.max(use, unuse);
    }

    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    /**
     * 题解：DP
     */
    public int jobSchedulingDp(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n + 1];
        Job[] job = new Job[n];
        for (int i = 0; i < n; i++) {
            job[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(job, Comparator.comparingInt(o -> o.endTime));
        dp[0] = job[0].profit;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], job[i].profit);
            for (int j = i - 1; j >= 0; j--) {
                if (job[j].endTime <= job[i].startTime) {
                    dp[i] = Math.max(dp[i], dp[j] + job[i].profit);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}