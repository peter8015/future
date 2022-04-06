package com.future.algorithm;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * 区间内链表反转 O(n)
 */
public class ReverseBetween {
    @Test
    public void t1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode r = reverse(l1);
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);

        BigInteger a = new BigInteger("100");
        BigInteger b = new BigInteger("50");

        System.out.println(a.mod(b));

        Integer c = 100;
        Integer d = 50;

        System.out.println(c % d);
        System.out.println(c / d);

    }

    //O(n)
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public ListNode reverseBetween(ListNode head, int m, int n)  {
        if(m == 1) {
            head.next = reverseTopN(head, n);
        }

        ListNode between = reverseBetween(head.next, m - 1, n - 1);
        head.next = between;
        return head;
    }

    ListNode topNSuccess = null;

    public ListNode reverseTopN(ListNode head, int n) {
        topNSuccess = head.next;
        return head;
    }

//    ListNode newHead = reverseTopN(head.next, n - 1);
//    head.next.next = head;
//    head.next = topNSuccess;



}
















