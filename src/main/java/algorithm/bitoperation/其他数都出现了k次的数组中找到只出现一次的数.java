package algorithm.bitoperation;

/**
 * 给定一个整型数组，和一个大于1的整数k，已知arr中只有一个数出现了一次，其他的数都出现了k次，请返回只出现一次的数。
 * <p>
 * 要求：时间复杂度为O(N)，额外空间复杂度为O(1)。
 * <p>
 * 解析：
 * 两个七进制的a和b，在i位上无进位相加的结果就是(a(i)+b(i))%7，同理，k进制的两个数，
 * 第i位上无进位相加的结果就是(c(i)+d(i))%k。那么，如果k个相同的k进制数进行无进位相加之，
 * 相加的结果一定是每一位上都为0的k进制数。
 *
 * @author: FuBiaoLiu
 * @date: 2020/3/12
 */
public class 其他数都出现了k次的数组中找到只出现一次的数 {
    /**
     * 找到只出现一次的数
     *
     * @param arr
     * @param k
     * @return
     */
    public int onceNum(int[] arr, int k) {
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO, arr[i], k);
        }
        return getNumFromKSysNum(eO, k);
    }

    public void setExclusiveOr(int[] eO, int value, int k) {
        int[] curKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i != eO.length; i++) {
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    public int[] getKSysNumFromNum(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    public int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }
}