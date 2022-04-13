package com.future.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 动态规划：爬楼梯
 */
public class ClimbStairs {

    @Test
    public void t1() {
        assertEquals(3, climb(3));
        assertEquals(2, climb(2));
        assertEquals(1, climb(1));
        assertEquals(7, climb(4));
    }

    public int climb(int n) {
        // TODO: 4/11/22 add bound and exception logic
        if(n == 0 || n == 1 || n == 2) return n;
        // TODO: 4/11/22 add result define
        // TODO: 4/11/22 add dp and mem logic
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;

        for(int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }
}
