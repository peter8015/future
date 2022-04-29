package com.future.mianshijindian;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {


    //计算气温回升情况  [21,23,17,28]  ， 如果比当天气温升高，则记录为1，如果过两天才升高，则记录为2  coupang 算法
//    还有一个促销系统的设计
    @Test
    public void t1() {
//        [21,23,17,28]
//        [1,2,1,0]

        int[] ints = new int[]{21,23,17,28};
        List<Integer> r = find(ints);

        assertEquals(1, r.get(0));
        assertEquals(2, r.get(1));
    }

    /**
     * O(n^2)  O(n)
     * @param nums
     *
     * @return
     */
    public List<Integer> find(int[] nums) {
        List<Integer> r = new ArrayList<>();

        //bound logical
        if(nums == null)  return r;

        int  len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            int num = nums[i];
            for(int k = i + 1; k != len; k++) {
                if(nums[k] <= num) {
                    count++;
                } else {
                    break;
                }
            }
            r.add(count);
        }
        return r;
    }
}