package com.future.algorithm;



import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    @Test
    public void t1() {
        int[] nums = new int[]{1,2,3,5,7};
        int target = 6;

        int[] r = findA(nums, target);
        System.out.println("i1=" + r[0] + "," + "i2=" + r[1]);
    }

    /**
     * O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private int[] find(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int k = 0; k < nums.length; k++) {
                if(nums[i] + nums[k] == target) {
                    return new int[]{i,k};
                }
            }
        }
        return null;
    }

    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] findA(int[] nums, int target) {

        int[] r = new int[2];
        int len = nums.length;
        int a = 0, b = 0;
        Map<Integer, Integer> maps = new HashMap();

        for(int i = 0; i < len; i++) {
            a = nums[i];
            b = target - a;

            if(maps.containsKey(b)) {
                r[0] = i;
                r[1] = maps.get(b);

                break;
            } else {
                maps.put(a, i);
            }
        }
        return r;
    }
}
