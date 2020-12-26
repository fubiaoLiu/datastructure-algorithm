package leetcode.sort;

/**
 * 给你一个整数数组 nums，将该数组升序排列。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * <p>
 * https://leetcode-cn.com/problems/sort-an-array
 *
 * @author FuBiaoLiu
 * @since 2020/3/31
 */
public class _912_排序树组 {
    private int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        sort(0, nums.length);
        return nums;
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int pivot = pivotIndex(begin, end);
        sort(begin, pivot);
        sort(pivot + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        int pivot = nums[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (nums[end] >= pivot) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end) {
                if (nums[begin] <= pivot) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }

        nums[begin] = pivot;
        return begin;
    }

    private void swap(int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    /**
     * LeetCode范例
     * 思路：将数组的值映射到一个统计数组，每有一个数字，相应下标的统计值+1，最后对统计数组进行转换。
     *
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else if (max < nums[i]) {
                max = nums[i];
            }
        }
        int range = max - min + 1;

        int[] counts = new int[range];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        for (int i = 0, j = 0; i < range; i++) {
            while (counts[i]-- > 0) {
                nums[j++] = i + min;
            }
        }
        return nums;
    }
}
