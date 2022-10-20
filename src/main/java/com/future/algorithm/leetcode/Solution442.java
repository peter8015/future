package com.future.algorithm.leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 * 链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 */
public class Solution442 {

    @Test
    public void t1() {
        int[] nums = new int[]{4,3,2,7,8,2,3,1,1};

        List<Integer> r = findDuplicates(nums);
        System.out.println(r.get(0));
        System.out.println(r.get(1));
        System.out.println(r.get(2));

    }

    public List<Integer> find(int[] nums) {
        List<Integer> r = new ArrayList();

        Set<Integer> sets = new HashSet();
        sets.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {

            if(sets.contains(nums[i])) {
                System.out.println(nums[i]);
                r.add(nums[i]);
                continue;
            } else {
                sets.add(nums[i]);
            }
        }


        return r;

    }

    /**
     * 方法一：将元素交换到对应的位置
     * O(n),O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = 0;

        temp = a;
        a = b;
        b = temp;
    }



}
