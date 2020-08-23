package leetcode.characterstring;

/**
 * @description: 无重复字符的最长子串
 * @author: liufb
 * @create: 2020/8/14 14:19
 **/
public class _3_无重复字符的最长子串 {
    /**
     * 注释部分代码，用于打印最长子串内容
     *
     * @param s 母串
     * @return 最长子串长度
     */
    public int longOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] lastIndexArray = new int[26];
        char[] chars = s.toLowerCase().toCharArray();
        int max = 0;
//        int maxStart = 1;
        int start = 1;
        int ascii;
        for (int i = 1; i <= chars.length; i++) {
            ascii = chars[i - 1] - 97;
            int lastIndex = lastIndexArray[ascii];
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }
//            if (max < i - start + 1) {
//                maxStart = start;
//            }
            max = Math.max(max, i - start + 1);
            lastIndexArray[ascii] = i;
        }
//        System.out.println(text.substring(maxStart - 1, maxStart + max - 1));
        return max;
    }
}
