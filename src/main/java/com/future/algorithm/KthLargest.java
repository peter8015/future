package com.future.algorithm;


import java.util.PriorityQueue;

/**
 * 题目：设计一个在数据流中找到第k大元素的类。
 * input: {13, 25, 33, 66, 7};  k=3  add key 8
 * output:  13
 *
 * 思路： 使用堆排序思想，找出第k大元素，用优先级队列实现。
 * 时间复杂度为O(nlogn)  空间复杂度
 * 构建堆的平均时间复杂度为O(n)
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {
    // think: heap implement
    // time complexity: O(nlogk)

    // todo priorityqueue
    private int k;
    private PriorityQueue<Integer> queue;

    // todo: construct init
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue(k);

        for(int num : nums) {
            add(num);
        }
    }

    // todo add:compare
    public int add(int key) {
        if(queue.size() > k) {
            queue.poll();
        }
        queue.offer(key);

        return queue.peek();
    }
    // todo exception logic

    // todo test
    public static void main(String[] args) {
        int[] nums = new int[]{13, 25, 33, 66, 7};
        final int k = 3, key = 8, key1 = 10;

        KthLargest kthLargest = new KthLargest(k, nums);
        int r = kthLargest.add(key); //13
        int r1 = kthLargest.add(key1); //10

        System.out.println(r);
        System.out.println(r1);
    }
}