package com.future.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 120. 三角形最小路径和
 * 给定一个三角型，找出自项向下的最小路径和
 * https://leetcode.cn/problems/triangle/
 */

public class Solution120 {
    int[][] memo;

    @Test
    public void t() {
        List<List<Integer>> data = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));

        int result = minimumTotal(data);
        assertEquals(11, result);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
