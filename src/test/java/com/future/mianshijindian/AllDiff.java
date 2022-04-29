package com.future.mianshijindian;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 题目：判断一个字符串中所有的字符都不相同
 * 思路: 两层for循环O(n^2) O(1)；使用set O(n) O(n)
 */
public class AllDiff {

    @Test
    public void t1() {
        String s1 = "abc";
        String s3 = "a";
        String s4 = null;
        String s5 = "abac";

        assertTrue(allDiff3(s1));
        assertTrue(allDiff3(s3));
        assertFalse(allDiff3(s4));
        assertFalse(allDiff3(s5));
    }

    /**
     * 解法一：use set
     * O(n) O(n)
     */
    public boolean allDiff1(String s) {
        // add bound logic
        if(s == null) return false;
        if(s.length() == 1) return true;

        // convert to char,and use set
        char[] chars = s.toCharArray();
        int len = chars.length;
        Set<Character> sets = new HashSet();

        for(int i = 0; i < len; i++) {
            if(!sets.add(chars[i])) {
               return false;
            }
        }
        return true;
    }

    /**
     * 解法二：
     * 1. nest loop  O(n^2) O(1)
     * 2. set O(n) O(n)
     * 3. |  ^  &
     * "abc"-> set a, b, c-> add -> false
     */
    public boolean isDiff2(String s) {
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

    /**
     * 解法3：use booean array
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean allDiff3(String s) {
        // TODO: 4/12/22 add bound logic
        if(s == null) return false;
        if(s.length() == 1) return true;

        // TODO: 4/12/22 add logic use boolean array
        boolean[] boos = new boolean[256];
        char[] chars = s.toCharArray();
        int len = chars.length;

        for(int i = 0; i < len; i++) {
            char c = chars[i];
            if(boos[c]) {
                return false;
            } else {
                boos[c] = true;
            }
        }
        return true;
    }
}