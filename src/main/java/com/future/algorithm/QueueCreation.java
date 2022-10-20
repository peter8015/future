package com.future.algorithm;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class QueueCreation {
    @Test
    public void t1() {
        int[] nums = new int[]{1,2,3};
        Stack s = add(nums);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }


    }


    public Stack<Integer> add(int[] nums) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for(int k : nums) {
            s1.push(k);
        }

        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2;
    }



    @Test
    public void t2() {
        Set<Integer> sets = new HashSet();
        boolean b = sets.add(1);
        System.out.println(b);


    }

}




