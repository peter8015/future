package com.future.algorithm.leetcode;

import cn.hutool.log.StaticLog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class Solution70 {

    @Test
    public void t1() {
        // 1, 2, 3, 5
        int r = clim4(4);
        StaticLog.info("r : {}", r);
        assertEquals(5, r);
    }

    /**
     * 解法三：动态规划法，可用滚动数组进一步优化，空间复杂度可优化为O(1)
     * 用dp数组来记录状态
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int clim3(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int clim4(int n) {
        if(n == 1) return 1;

        int first = 1;
        int second = 2;
        int third = 0;

        for(int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    /**
     * 解法一：递归解法
     *  * 1级楼梯时有一种方法
     *  * 2级楼梯时有两种方法
     *  * 3级。。。。三种方法
     *  * 1，2，3，5....后面的数等于前面两数之和，就是fibonacci算法
     */
    public int clim(int k) {
        if(k == 1) {
            return 1;
        } if(k == 2) {
            return 2;
        } else {
            return clim(k - 1) + clim(k - 2);
        }
    }

    /**
     * 解法二：用记忆化递归的方法， 避免重复计算
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @return
     */
    public int clim1(int n) {
        int[] mem = new int[n + 1];

        if(n == 1) {
            mem[n] = 1;
        } else if(n == 2) {
            mem[n] = 2;
        } else {
            mem[n] = clim1(n - 1) + clim1(n - 2);
        }
        return mem[n];
    }
}
