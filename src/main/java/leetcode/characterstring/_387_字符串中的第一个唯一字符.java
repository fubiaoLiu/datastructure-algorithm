package leetcode.characterstring;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * Related Topics 哈希表 字符串
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author FuBiaoLiu
 * @since 2020/12/20
 */
public class _387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return -1;
        }
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
