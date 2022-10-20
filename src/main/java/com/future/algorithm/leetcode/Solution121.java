package com.future.algorithm.leetcode;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Solution121 {

    @Test
    public void t1() {
        int[] nums = {7, 1, 4, 5, 6, 3};

        int max_profit = maxProfit2(nums);
        Console.log("max profit is : {}", max_profit);
    }

    /*
     * 暴力解法
     * time complex: O(n^2)
     * space complex: O(1)
     */
    public int maxProfit1(int[] nums) {
        int maxProfit = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int profit = nums[j] - nums[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }


    /**
     * time complex:O(n)，n为数组的长度
     * space complex: O(1),只使用了常数个变量
     *
     * @param nums
     * @return
     */
    public int maxProfit(int[] nums) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] < min_price) {
                min_price = nums[i];
            } else if (nums[i] - min_price > max_profit) {
                max_profit = nums[i] - min_price;
            }
        }
        return max_profit;
    }

    /**
     * 思路：需要维护两个变量：最小价格minprirce和最大利润maxProfit，遍历价格数组，
     * 找到最小价格和最大利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < len; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
