package com.future.mianshijindian;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * 给定两个字符串，确定其中一个字符串的字符重新排序后，能否变成另外一个字符串（变位词）
 *
 * input:[abcd]
 * output:[dcba]
 */
public class isSameAfterReverse {
    //test code
    @Test
    public void t1() {
        String source = "1324";
        String target = "1432";

        assertTrue(isSame(source, target));
    }

    public boolean isSame(String source, String target) {
        //bound logic
        if(source == null || target == null) {
            return false;
        }
        if(source.equals(target)) {
            return true;
        }

        // return false if s.len != t.len
        if(source.length() != target.length()) {
            return false;
        }

        //Arrays.sort(String)
        char[] c_s = source.toCharArray();
        char[] c_t = target.toCharArray();
        Arrays.sort(c_s);
        Arrays.sort(c_t);

        //todo compare logic
        String s1 = new String(c_s), s2 = new String(c_t);
        return s1.equals(s2);
    }
}