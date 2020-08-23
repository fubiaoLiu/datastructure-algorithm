package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _6_Test {
    _6_Z字形变换 convert = new _6_Z字形变换();

    @Test
    public void should_return_LEETCODEISHIRING_3_given_LCIRETOESIIGEDHN() {
        String text = "LEETCODEISHIRING";
        int numRows = 3;
        String expectedString = "LCIRETOESIIGEDHN";
        String actualString = convert.convert(text, numRows);
        assertEquals(expectedString, actualString);
    }

    @Test
    public void should_return_LEETCODEISHIRING_4_given_LDREOEIIECIHNTSG() {
        String text = "LEETCODEISHIRING";
        int numRows = 4;
        String expectedString = "LDREOEIIECIHNTSG";
        String actualString = convert.convert(text, numRows);
        assertEquals(expectedString, actualString);
    }
}
