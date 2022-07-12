package com.future.othertest;

import com.future.algorithm.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class ReverTest {
    public static int[] reversePrint(ListNode head) {
        ListNode temp = reverse(head);

        int[] r = new int[10];
        int c = 0;

        while (temp != null) {
            r[c++] = temp.val;
            temp = temp.next;
        }


        return r;

    }

    //O(n) O(1)
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        Integer x = 1;
        int y = x;
    }


    public static int[] reverseUseStack(ListNode head) {
        Stack<Integer> stack = new Stack();

        while (head != null) {
            System.out.println(head.val);
            stack.push(head.val);
            head = head.next;
        }

        System.out.println("statck size:" + stack.size());

        int size = stack.size();
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = stack.pop();
        }
        return r;
    }


    public synchronized void method1() {

    }

    public void method2() {
        synchronized (this) {

        }
    }
}