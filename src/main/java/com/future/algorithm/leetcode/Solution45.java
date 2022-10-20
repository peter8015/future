package com.future.algorithm.leetcode;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

//跳跃游戏II
public class Solution45 {

    @Test
    public void t() {
        int[] nums = new int[]{2, 3, 1, 1, 4, 5};

        int step = jump(nums);

        assertEquals(3, step);
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int maxPos = 0, end = 0, step = 0;

        for(int i = 0; i < length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);

            if(i == end) {
                end = maxPos;
                step++;
            }
        }

        return step;
    }

}
