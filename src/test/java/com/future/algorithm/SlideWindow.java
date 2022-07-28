package com.future.algorithm;


import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;


/**
 * 给定一个整形数组nums，有一个大小为k的滑动窗口。只能看到滑动窗口的数字，
 * 滑动窗口每移动一位，返回窗口中的最大值。
 * 示例：
 * input: [-1,2,3,5,8,2,9]
 * output: [3,5,8,8,9]
 */
public class SlideWindow {


    public void t1() {
        int[] nums = {1,2,3,4,5,6};
        int[] expect = {3,4,5,6};

        int[] actual = slideWindow(nums);
        assertEquals(expect[0], actual[0]);

    }

    private int[] slideWindow(int[] nums) {
        return null;
    }


}
