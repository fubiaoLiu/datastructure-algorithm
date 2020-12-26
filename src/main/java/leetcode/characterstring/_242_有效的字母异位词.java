package leetcode.characterstring;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * Related Topics 排序 哈希表
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram
 *
 * @author Fubiao.Liu
 * @since 2020/12/14 17:43
 **/
public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] schars = s.toCharArray();
        int index;
        for (char schar : schars) {
            index = schar - 'a';
            counts[index]++;
        }
        char[] tchars = t.toCharArray();
        for (char tchar : tchars) {
            index = tchar - 'a';
            if (counts[index] == 0) {
                return false;
            }
            counts[index]--;
        }
        return true;
    }
}