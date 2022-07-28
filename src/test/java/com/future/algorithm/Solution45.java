package com.future.algorithm;

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

    //O(n), O(1)
    public int jump(int[] nums) {
        int len = nums.length;
        int maxPos = 0, end = 0, step = 0;

        for(int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);

            if(i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
