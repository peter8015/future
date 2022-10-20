package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组中重复的数字：在一个长度为n的数组里所有的数字都在0~n-1范围内。数组中某些数字是重复的，
 * 但不知道重复的有几个，重复了几次。请找出数组中任意一个重复的数字。
 * 2 <= n <= 100000
 * 方案一：暴力求解 遍历数组中的每一个元素，在剩余的数字中寻找相同数字
 * 时间复杂度：  O(n^2)  空间复杂度  O(1)
 * 方案二：哈希查找
 * 1. 先创建一个哈希表（hashset）
 * 2. 然后遍历每一个元素，进行如下处理
 * - 如果哈希表不存在则加入哈希表
 * - 如果哈希表中存在则直接返回
 * 空间换时间，时间复杂度为O(n)
 * 空间复杂度为O(n)
 */
public class Offer03 {
    @Test
    public void t1() {
        int[] nums = new int[]{1,2,3,4,5,2,3};
        System.out.println(findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet();

        for(int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if(sets.contains(k)) {
                return k;
            } else {
                sets.add(k);
            }
        }
        return -1;
    }
}
