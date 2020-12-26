package leetcode.sort;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * <p>
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * Related Topics 排序
 * <p>
 * https://leetcode-cn.com/problems/maximum-gap
 *
 * @author Fubiao.Liu
 * @since 2020/11/30 16:42
 **/
public class _164_最大间距 {
    /**
     * 基于桶的算法（最大间距肯定在不同桶之间，不会出现同一个桶内的两个元素间）
     * 根据元素平均间距，生成指定数量的桶，元素根据平均间距放入对应的桶
     * 每个桶维护桶内元素的最大最小值，最后计算桶之间的最大间距就是元素的最大间距
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();
        int avgSpacing = Math.max(1, (maxVal - minVal) / (length - 1));
        int bucketCount = (maxVal - minVal) / avgSpacing + 1;

        // 初始化，元素不会是负数，初始化桶内的最大、最小值为-1
        int[][] buckets = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            Arrays.fill(buckets[i], -1);
        }
        for (int num : nums) {
            int bucketIdx = (num - minVal) / avgSpacing;
            if (buckets[bucketIdx][0] == -1) {
                buckets[bucketIdx][0] = buckets[bucketIdx][1] = num;
            } else {
                buckets[bucketIdx][0] = Math.min(buckets[bucketIdx][0], num);
                buckets[bucketIdx][1] = Math.max(buckets[bucketIdx][1], num);
            }
        }

        int maxGap = 0;
        int prev = -1;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                maxGap = Math.max(maxGap, buckets[i][0] - prev);
            }
            prev = buckets[i][1];
        }
        return maxGap;
    }

    /**
     * 基数排序
     */
    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length;
        int[] buf = new int[length];
        int exp = 1;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int num : nums) {
                cnt[(num / exp) % 10]++;
            }
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = length - 1; i >= 0; i--) {
                buf[--cnt[(nums[i] / exp) % 10]] = nums[i];
            }
            exp *= 10;
            System.arraycopy(buf, 0, nums, 0, length);
        }
        int maxGap = 0;
        for (int i = 1; i < length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }

    /**
     * 官方题解：基数排序
     */
    public int maximumGapBase(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        // 用于取每一位的值，1表示取个位数，10表示取十位数
        long exp = 1;
        // 临时存储排序过程中一轮排序的结果，然后应用到nums
        int[] buf = new int[n];
        // 获取数组元素最大值
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            // 存储指定位数的值为0~9的元素的个数
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                // 取元素指定位数的值
                int digit = (nums[i] / (int) exp) % 10;
                // 对应值下标的计数+1
                cnt[digit]++;
            }
            // 计算指定位数数字小于等于当前下标的元素的数量
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            // 将元素按指定位数值的顺序放入buf数组
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            // 将buf数组的元素应用到nums数组，完成一轮排序（某一位数字的排序）
            System.arraycopy(buf, 0, nums, 0, n);
            // 位数+1
            exp *= 10;
        }

        // 遍历排序好的数组取最大间距
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

    /**
     * 官方题解：基于桶的算法
     */
    public int maximumGapBucket(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        // 每个元素间的平均间距，小于1取1
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        // 获取桶的数量：（最大值-最小值）/ 平均间距 + 1
        // 根据d的计算方式可以知道，如果d大于1，这里桶的数量会大于等于元素数量
        int bucketSize = (maxVal - minVal) / d + 1;

        // 存储每个桶里的最大值和最小值
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            // 根据平均间距计算元素所在的桶
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        // 计算后一个桶最小值和前一个桶最大值的差，这个差值的最大值就是所有元素的最大间距
        // 因为同一个桶内的最大间距肯定小于平均间距
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}