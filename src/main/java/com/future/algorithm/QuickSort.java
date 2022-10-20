package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * 题目：对给定的数组进行排序
 * 示例：
 *      输入： [1,2,9,7,5,4,3]
 *      输出   [1,2,3,4,5,7,9]
 * 分析：
 * 1. 选取：枢纽元素pivot进行分区，一般为第一个元素。
 * 2. 分区：比pivot大的元素放到右边，小的放在左边。
 * 3. 递归：对左右分区进行第二步的操作， 直到只剩余一个元素为止。
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：
 */
public class QuickSort {
    @Test
    public void t1() {
        int[] nums = {1,2,9,7,5,4,3};

        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
        assertEquals(5, nums[4]);
        assertEquals(7, nums[5]);
        assertEquals(9, nums[6]);
    }

    //实现递归
    public void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int k = patition(nums, low, high);

            quickSort(nums, low, k);
            quickSort(nums, k + 1, high);
        }
    }

    public int patition(int[] nums, int low, int high) {
        int i = low, j = high;
        int pivot = nums[low];

        if(i < j) {
            while(i < j) {
                while(i < j && nums[j] >= pivot) {
                    j--;
                }
                if( i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while(i < j && nums[i] <= pivot) {
                    i++;
                }
                if(i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = pivot;
        }
        return i;
    }
}
