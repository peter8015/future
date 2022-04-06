package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode-cn  120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 时间复杂度：O(n^2) n为三角形的行数
 * 空间复杂度：O(n^2) n为三角形的行数
 */
public class TriangleMin {
    @Test
    public void t1() {
        List<List<Integer>> triangles = new ArrayList<>();

        List<Integer> e1 = new ArrayList<>();
        e1.add(2);
        triangles.add(e1);
        List<Integer> e2 = new ArrayList<>();
        e2.add(3);
        e2.add(4);
        triangles.add(e2);
        List<Integer> e3 = new ArrayList<>();
        e3.add(6);
        e3.add(5);
        e3.add(7);
        triangles.add(e3);
        List<Integer> e4 = new ArrayList<>();
        e4.add(4);
        e4.add(1);
        e4.add(8);
        e4.add(3);
        triangles.add(e4);

        System.out.println(minTotal(triangles));
    }

    /**
     * 动态规划. 定义二维 dp 数组，将解法二中「自顶向下的递归」改为「自底向上的递推」。
     * 1. 状态定义：dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和。
     * 2. 状态转移：dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
     * @param triangles
     * @return
     */
    public int minTotal(List<List<Integer>> triangles) {
        //todo 定义状态
        int n = triangles.size();
        int dp[][] = new int[n + 1][n + 1];

        //todo 定义状态转移方程
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangles.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
