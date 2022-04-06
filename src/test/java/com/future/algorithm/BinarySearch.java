package com.future.algorithm;


import org.junit.jupiter.api.Test;

/**
 * 给定一个n个元素的数组和一个目标值target，写一个函数在nums中搜索目标值 target。
 */
public class BinarySearch {
    @Test
    public void t1() {
        int[] nums = {-3, 1, 2, 4, 6};
        binarySearch(nums, 4);
    }

    public int binarySearch(int[] nums, int key) {
        if(null == nums) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;

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
}
