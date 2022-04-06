package com.future.mianshijindian;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 判断一个字符串中所有的字符都不相同
 */
public class AllDiff {

    /**
     * test cases
     */
    @Test
    public void t1() {
        String s1 = "abc";
        String s2 = "123";
        String s3 = "a";
        String s4 = null;

        assertTrue(isDiffA(s1));
        assertTrue(isDiffA(s2));
        assertTrue(isDiffA(s3));
        assertFalse(isDiffA(s4));
    }

    /**
     * 1. nest loop  O(n^2) O(1)
     * 2. set O(n) O(n)
     * 3. |  ^  &
     * "abc"-> set a, b, c-> add -> false
     *
     * @param s
     * @return
     */
    public boolean isDiff(String s) {
        boolean r = true;
        if(s == null) return r;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            for (int k = i + 1; k < chars.length; k++) {
                if (c == chars[k]) {
                    r = false;
                    break;
                }
            }
        }
        return r;
    }

    /** O(n) O(n) */
    public boolean isDiffA(String s) {
        boolean r = true;

        //bound logic
        if(s == null) return r;

        char[] chars = s.toCharArray();
        int len = chars.length;
        Set<Character> sets = new HashSet();

        for(int i = 0; i < len; i++) {
            char c = chars[i];
            if(sets.contains(c)) {
                r = false;
                break;
            } else {
                sets.add(c);
            }
         }
        return r;
    }

    /**
     * Defined boolean array store char of string.
     * Set true if char exist.
     * 时间复杂度O(n), n 为字符串长度，空间复杂度为O(1)
     * @param s
     * @return
     */
    public boolean isDiffB(String s) {
        char[] chars = s.toCharArray();

        //bound logic
        if(s == null) {
            return false;
        }

        //defined boolean arrays
        boolean[] bs = new boolean[256];

        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(bs[c]) {
                return false;
            }
            bs[c] = true;
        }
        return true;
    }

    @Test
    public void t2() {
        char a = 'a';
        char b = 'b';

//        System.out.println(a & b);
//        System.out.println(a | b);
        System.out.println(a ^ b);
    }
}
