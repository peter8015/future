package com.future.algorithm;


import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个整形数组nums，有一个大小为k的滑动窗口。只能看到滑动窗口的数字，
 * 滑动窗口每移动一位，返回窗口中的最大值。
 * 示例：input: [-1,2,3,5,8,2,9]
 * output: [3,5,8,8,9]
 */
public class SlideWindow {
    @Test
    public void t1() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new int[]{3, 3, 5, 5, 6, 7};
        int k = 3;
        int count = 100;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int m = 0; m < 100; m++) {
            int[] r = maxSlidingWindow(nums, k);
            for (int i = 0; i < r.length; i++) {
                System.out.println(r[i]);
                assertEquals(result[i], r[i]);
            }
        }

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis() + "ms!");
    }

    @Test
    public void t2() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new int[]{3, 3, 5, 5, 6, 7};
        int k = 3;

        int[] r = maxSlidingWindow1(nums, k);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
            assertEquals(result[i], r[i]);
        }
    }


    /**
     * 使用dequeue解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //窗口个数
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        //遍历数组中元素，right表示窗口右边界
        for (int right = 0; right < nums.length; right++) {
            //如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.removeLast();
            }

            //存储元素下标
            queue.addLast(right);

            int left = right - k + 1;
            //当队首元素小于左边界时，移除首元素
            if (left > queue.peekFirst()) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


    @Test
    public void t3() {
        //问题：给定一个数组nums，有一个大小为k的滑动窗口。滑动窗口在数组上移动，只能看到滑动窗口内的数字，窗口每移动一位
        //返回窗口内的最大数字。
        //示例：输入[-1,1,3,5,8,3,9] k = 3 输出：[3,5,8,8,9]

        int[] nums = new int[]{-1,1,3,5,8,3,9};
        int[] result = new int[]{3,5,8,8,9};
        int k = 3;

        int[] res = maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++) {
            assertEquals(result[i], res[i]);
        }
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        //确定返回数组的大小
        int[] res = new int[nums.length - k + 1];
        //利用双端队列队列
        LinkedList<Integer> queue = new LinkedList<>();

        //循环数组，用队列处理
        for(int right = 0; right < nums.length; right++) {
            //如果数组右边界元素大于队列最后元素，删除队列元素
            while(!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.removeLast();
            }

            //索引加入队列
            queue.addLast(right);

            //如果数组左边的元素大于队列首元素，删除队首元素
            int left = right - k + 1;
            if(left > queue.peekFirst()) {
                queue.removeFirst();
            }

            //处理索引为0的元素
            if(right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
