package algorithm.bloomfilter;

/**
 * 布隆过滤器
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/7
 */
public class BloomFilter<T> {
    private double p;
    private int n;
    /**
     * 二进制向量的长度
     */
    private int bitSize;
    /**
     * 二进制向量
     */
    private long[] bits;
    /**
     * hash函数个数
     */
    private int k;

    /**
     * @param p 误判率
     * @param n 数据规模
     */
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p >= 1) {
            throw new IllegalArgumentException("数据规模或误判率参数不合法！");
        }
        this.p = p;
        this.n = n;
        double ln2 = Math.log(2);
        this.bitSize = (int) (-n * Math.log(p) / (ln2 * ln2));
        this.bits = new long[(bitSize - 1) / Long.SIZE + 1];
        this.k = (int) (bitSize * ln2 / n);
    }

    public boolean put(T t) {
        paramCheck(t);
        // 使用hash函数分别计算出几个哈希值
        // 利用t生成2个整数
        int hash1 = t.hashCode();
        int hash2 = hash1 >>> 16;

        boolean result = false;
        for (int i = 0; i < k; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            // 生成一个二进位的索引
            int index = combinedHash % bitSize;
            // 修改index位置的二进位为1
            if (setValueByIndex(index)) {
                result = true;
            }
        }
        return result;
    }

    public boolean contains(T t) {
        paramCheck(t);
        // 使用hash函数分别计算出几个哈希值，并判断二进制向量中对应位置的值是否为1，全为1返回true，否则返回false。
        int hash1 = t.hashCode();
        int hash2 = hash1 >>> 16;
        for (int i = 0; i < k; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            // 生成一个二进位的索引
            int index = combinedHash % bitSize;
            // 判断index位置的二进位的值是否为1
            if (!getValueByIndex(index)) {
                return false;
            }
        }
        return true;
    }

    private void paramCheck(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Value must not be null.");
        }
    }

    /**
     * 查看index位置的值
     *
     * @param index
     * @return true:1;false:0.
     */
    private boolean getValueByIndex(int index) {
        return (bits[index / Long.SIZE] & (1 << index % Long.SIZE)) != 0;
    }

    /**
     * 设置index位置的值为1
     *
     * @param index
     * @return true:有变更; false:无变更
     */
    private boolean setValueByIndex(int index) {
        int regionIndex = index / Long.SIZE;
        long region = bits[regionIndex];
        long bitIndex = 1 << (index % Long.SIZE);
        if ((region & bitIndex) != 0) {
            return false;
        }
        bits[regionIndex] = region | bitIndex;
        return true;
    }
}
