package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.Assertions.assertListEquals;
import static utils.Assertions.assertListEqualsDisorder;

public class _93_Test {
    _93_复原IP地址 obj = new _93_复原IP地址();

    @Test
    public void test1() {
        String s = "25525511135";
        List<String> expected = new ArrayList<>();
        expected.add("255.255.11.135");
        expected.add("255.255.111.35");
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }

    @Test
    public void test2() {
        String s = "0000";
        List<String> expected = new ArrayList<>();
        expected.add("0.0.0.0");
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }

    @Test
    public void test3() {
        String s = "1111";
        List<String> expected = new ArrayList<>();
        expected.add("1.1.1.1");
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }

    @Test
    public void test4() {
        String s = "010010";
        List<String> expected = new ArrayList<>();
        expected.add("0.10.0.10");
        expected.add("0.100.1.0");
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }

    @Test
    public void test5() {
        String s = "101023";
        List<String> expected = new ArrayList<>();
        expected.add("1.0.10.23");
        expected.add("1.0.102.3");
        expected.add("10.1.0.23");
        expected.add("10.10.2.3");
        expected.add("101.0.2.3");
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }

    @Test
    public void test6() {
        String s = "";
        List<String> expected = new ArrayList<>();
        List<String> actual = obj.restoreIpAddresses(s);
        assertListEqualsDisorder(expected, actual);
    }
}
