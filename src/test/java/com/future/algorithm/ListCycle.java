package com.future.algorithm;


import org.junit.jupiter.api.Test;

/**
 * 判断一个链表是否有环
 *
 */
public class ListCycle {

    @Test
    public void t1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;
        n5.next = n2;


        boolean b = hasCycle(n1);
        System.out.println(b);
//        assertTrue(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
