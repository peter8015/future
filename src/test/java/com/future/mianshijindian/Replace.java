package com.future.mianshijindian;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 编写一个方法，将字符串的空格全部替换成"%20"
 * input: "abc d  e"
 * input: "abc%20d%20e"
 */
public class Replace {
    @Test
    public void t1() {
        String source = "abc d  e";
        String source1 = null;

        String target = "abc%20d%20e";

        assertEquals(target, replace(source));
        assertEquals(null, replace(source1));  // if source==null
    }

    public String replace(String s) {
        //todo bound logic
        if(s == null) {
            return s;
        }

        //todo replace " " with "%20"
        char[] c_s = s.toCharArray();
        int count = 0;

        for(char c : c_s) {
            if(c == 0) {

            }
        }

        return null;
    }
}
