package com.future.algorithm.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.testng.AssertJUnit.assertEquals;

/**
 * 题目；给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 */
public class Solution215 {
    private static final Logger log = LoggerFactory.getLogger(Solution215.class);

    @Test
    public void t1() {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        int r = maxKth1(nums, k);
        log.info("The kth largest is : {}", r);

        assertEquals(5, r);
    }

    /**
     * 解决二：利用小顶堆来实现，维护一个包含k个数的小顶堆，堆项元素就是第k个大的元素。
     * 堆用优先级队列来实现。
     * 时间复杂度：O(n), n为数组长度
     */
    public int maxKth1(int[] nums, int k) {
        if(nums == null) {
            return -1;
        }

        final PriorityQueue<Integer> queue = new PriorityQueue(k);

        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * 先进行快速排序，然后取出
     * @param nums
     * @return
     */
    public int maxKth(int[] nums, int k) {
        Arrays.sort(nums);

        for(int num : nums) {
            log.info("num is : {}", num);
        }
        return nums[nums.length - k];
    }
}
