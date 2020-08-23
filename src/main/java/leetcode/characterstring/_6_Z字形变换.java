package leetcode.characterstring;

/**
 * @description: Z字形变换
 * @author: liufb
 * @create: 2020/8/14 16:14
 **/
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
