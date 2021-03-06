package leetcode.greedy;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * <p>
 * Related Topics 贪心算法 数组
 * <p>
 * https://leetcode-cn.com/problems/can-place-flowers
 *
 * @author FuBiaoLiu
 * @since 2020/2/5
 */
public class _605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                i++;
                n--;
            }
            i++;
        }
        return n == 0;
    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n <= 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if ((i > 0 && flowerbed[i - 1] == 1) || (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)) {
                continue;
            }
            flowerbed[i] = 1;
            if (--n == 0) {
                return true;
            }
            i++;
        }
        return false;
    }
}
