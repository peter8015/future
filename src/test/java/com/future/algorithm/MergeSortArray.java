package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * [1,2,3,0,0,0]  m=3  [2,4,5,6]  n=4
 * 给定两个"非递减顺序排列"的整数数组num1 和 num2, 另有两个整数m和n，
 * 分别代码两个数组中的元素的个数，请你合并nums2到nums1，并且使合并后的
 * 数组同样也按非递减顺序排列。
 *
 */
public class MergeSortArray {

    @Test
    public void t1() {
        int[] nums1 = new int[]{1,2,3,0,7,0};
        int[] nums2 = new int[]{4,5,6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    @Test
    public void t2() {
        int i = 0;
        for(int k = 0; k < 50; k++) {
            i = ++i;
        }
        System.out.println(i);
    }
}
