package leetcode.characterstring;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author FuBiaoLiu
 * @since 2020/12/20
 */
public class _6_Z字形变换 {
    /**
     * 方法三：按行访问（参考题解）
     * 通过从左向右迭代字符串，可以轻松确定字符位于Z字形图案中的行号
     * 时间复杂度：O(n)，其中 n = len(s)
     * 空间复杂度：O(n)
     *
     * @param s       原字符串
     * @param numRows 行数
     * @return 转换后的字符串
     */
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int cycleLen = (numRows << 1) - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < length; j += cycleLen) {
                result.append(chars[j + i]);
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < length) {
                    result.append(chars[j + cycleLen - i]);
                }
            }
        }
        return result.toString();
    }

    /**
     * 方法二：按行排序（参考题解，代码较方法一更简洁）
     * 通过从左向右迭代字符串，可以轻松确定字符位于Z字形图案中的行号
     * 时间复杂度：O(n)，其中 n = len(s)
     * 空间复杂度：O(n)
     *
     * @param s       原字符串
     * @param numRows 行数
     * @return 转换后的字符串
     */
    public String convert2(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }
        int goingDown = -1;
        char[] chars = s.toCharArray();
        int rowNum = 0;
        for (int i = 0; i < chars.length; i++, rowNum += goingDown) {
            sbArray[rowNum].append(chars[i]);
            if (rowNum == 0 || rowNum == numRows - 1) {
                goingDown = -goingDown;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbArray) {
            result.append(sb);
        }
        return result.toString();
    }

    /**
     * 方法一：按行排序，代码逻辑较复杂
     * 通过从左向右迭代字符串，可以轻松确定字符位于Z字形图案中的行号
     * 时间复杂度：O(n)，其中 n = len(s)
     * 空间复杂度：O(n)
     *
     * @param s       原字符串
     * @param numRows 行数
     * @return 转换后的字符串
     */
    public String convert1(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        String[] array = new String[numRows];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            int j = 0;
            for (; j < numRows - 1 && i < chars.length; j++, i++) {
                array[j] = (array[j] == null ? "" : array[j]) + chars[i];
            }
            for (; j > 0 && i < chars.length; j--, i++) {
                array[j] = (array[j] == null ? "" : array[j]) + chars[i];
            }
        }
        StringBuilder result = new StringBuilder();
        for (String value : array) {
            result.append(value);
        }
        return result.toString();
    }
}
