package com.future.algorithm;


import org.junit.Test;

import java.util.*;

/**
 * 给定一个整数数组，找出其中不重复的整数返回；找出其中重复的整数，并根据出现次数倒序返回
 * input: {1,1,1,2,2,3,3,3,3,5,6,7,8,8,8,8,8,8,8}
 * output1: 5,6,7
 * 1-3, 2- 2, 3-3,8-7
 * output2: 8，3， 1，2
 * <p>
 * //https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/comments/
 * //    https://www.iteye.com/blog/2751459205-2181764
 *
 * 方案一：暴力求解O(N^2)  O(1)
 * 方案二：哈希算法O(n) O(n)
 * 方案三：数组法O(n) O(n)
 * 方案四：最优解法O(n) O(1)
 */
public class FindUnique {

    @Test
    public void t1() {
        int[] ints = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5};
//        List<Integer> unique = findUnique(ints);
//        System.out.println(unique.size());

//        List<Integer> dup = findDuplicate(ints);

//        for (Integer i : dup) {
//            System.out.println(i);
//        }
    }

    //方法1：暴力求解 O(n^2)
    //方法2：借助 set  
    // TODO: 4/9/22 算法待优化
    public List<Integer> findUnique(int[] nums) {
        List<Integer> r = new ArrayList();

        //loop nums
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (r.contains(nums[i])) {
                continue;
            }
            for (int k = 0; k != nums.length; k++) {
                if (nums[i] != nums[k]) {
                    c++;
                }
            }

            //Adds element to result if it is different from all.
            if (c == nums.length - 1) {
                r.add(nums[i]);
            }
            c = 0;
        }
        return r;
    }

    /**
     * 找出重复的字符串，并计算重复出现的次数
     * O(2n)
     */
    @Test
    public void t3() {
        //test array
        String[] strs = new String[]{"a", "a", "a", "b", "b", "c", "a"};
        findDuplicateAndSortByCounter(strs);
    }

    private void findDuplicateAndSortByCounter(String[] strs) {
        //use map store string and counter
        Map<String, Integer> c_map = new HashMap();

        for (String s : strs) {
            Integer count = c_map.get(s);
            c_map.put(s, (count == null ? 1 : count + 1));
        }

        //将map转化成list，实现Compare接口。
        List<Map.Entry<String, Integer>> entries = new ArrayList(c_map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue() - o2.getValue());

        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println(String.format("key: %s, value:%s", entry.getKey(), entry.getValue()));
        }
    }


    @Test
    public void t4() {
        // TODO: 4/9/22 create test data.
        Map<String, Integer> data = new HashMap();
        data.put("a", 4);
        data.put("b", 2);
        data.put("c", 1);

        // TODO: 4/9/22 将map转化成list，实现Compare接口。
        List<Map.Entry<String, Integer>> entries = new ArrayList(data.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue() - o2.getValue());

        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println(String.format("key: %s, value:%s", entry.getKey(), entry.getValue()));
        }
    }


    /**
     * 方案四：最优解法  找出重复元素，不做记录
     * @param nums
     * @return
     *
     */
    public int findDupliates(int[] nums) {
        int[] r = new int[nums.length];

        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }

}