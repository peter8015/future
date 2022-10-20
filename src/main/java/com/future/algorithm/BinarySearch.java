package com.future.algorithm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 题目：给定一个n个元素的数组和一个目标值target，写一个函数在nums中搜索目标值 target。
 * 时间复杂度：O(log2n)
 * 空间复杂度：O(1) 
 * 
 * 思路：二分查找  // TODO: 4/12/22
 *
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int key) {
        if(null == nums) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;   // TODO: 4/12/22

            if(key == nums[mid]) {
                return mid;
            } else if(key < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    @Test
    public void t1() {
        int[] nums = {-3, 1, 2, 4, 6};

        assertEquals(-1, binarySearch(null, 4));
        assertEquals(3, binarySearch(nums, 4));
    }
}
