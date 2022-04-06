package com.future.algorithm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Dynamic programming
 * 动态规划：
 * 1.
 *
 * 斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * n <= 1 -> n
 * f[n] = f[n - 1] + f[n - 2];
 */
public class DP {

    @Test
    public void t1() {
        assertEquals(3, fib(4));
        assertEquals(21, fib(8));
        assertEquals(55, fib(10));

        int[] memo = new int[]{0};
//        assertEquals(3, fib(4, memo));
//        assertEquals(21, fib(8, memo));
//        assertEquals(55, fib(10, memo));

    }

    //时间复杂度为O(n^2)
    public int fib(int n) {
        if(n <= 0) {
            return 0;
        } if(n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
    public int fibx(int n, int[] memo) {
        if(n == 0 || n == 1) {
            retrun n;
        }

        for(int i = 0; i <= n; ++i) {
//            fibx()
        }
        return -1;
    }
*/

}



