package com.future.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Solution {
    @Test
    public void testHasCycle() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        boolean isHas = hasCycle(l1);
        assertFalse(isHas);
    }

//    O(n)  O(1)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast != slow) {
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next;
            slow = slow.next;
         }
        return false;
    }
}
