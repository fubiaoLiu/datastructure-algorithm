package leetcode.characterstring;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>
 * 示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 * <p>
 * 说明:
 * 你能只调用一次检查子串的方法吗？
 * <p>
 * Related Topics 字符串
 * <p>
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 *
 * @author Fubiao.Liu
 * @since 2020/12/10 16:56
 **/
public class _01_09_字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String tmp = s1 + s1;
        return tmp.contains(s2);
    }
}