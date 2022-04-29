package com.future.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 三数之和：给你一个包含n个元素的数组，判断是否存在三个元素a,b,c，使得a+b+c=0 ? 请找出
 * 所有和为0且不重复的三元组。
 * input: nums=[ -1, 0, 1, 2, -1, -4]
 * output: [[-1, -1, 2][-1, 0, 1]]
 * 思路：
 * 1. 排序后，定义两端向中间移动
 * 2. 利用set 存储 c = -(a+b)，但会有重复
 */
public class ThreeSum {

    @Test
    public void t1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> r = threeSumx(nums);

        r.stream().forEach((m) -> {
            m.stream().forEach((n) -> {
                System.out.println(n);
            });
        });
    }

    /**
     * 1. 暴力求解 a+b+c=0  O(n^3)
     * 2. 利用set， c = -(a + b)  => set  O(n^2)
     *
     * @param nums
     * @return
     */
    public List<int[]> findThreeSum(int[] nums) {
        List<int[]> r = new ArrayList<>();
        int len = nums.length;
        Set<Integer> sets = new HashSet();

        for (int i = 0; i < len; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            for (int k = i + 1; k != len; k++) {
                int b = nums[k];
                int c = -(a + b);

                if (sets.contains(-(a + b))) {
                    r.add(new int[]{a, b, c});
                } else {
                    sets.add(c);
                }
            }
        }
        return r;
    }

    //official version  O(N^2)  O(1)
    //三数之和为0， 由L，R分别向中间移动
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSumx(int[] nums) {
        // add bound logic
        if (nums == null || nums.length < 3) {
            return null;
        }
        // add result
        List<List<Integer>> r = new ArrayList();
        // array sort
        Arrays.sort(nums);

        // for loop, define l&r, move and get ride of dupliation
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) continue;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    r.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return r;
    }
}












