package com.future.algorithm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个链表进行反转输出
 * 例如： 1-2-3-4，反转后 4-3-2-1
 */
public class ReverseList {

    @Test
    public void t1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        //1->2->3->4  4->3->2->1
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode r = reverseList(n1);

        assertEquals(4, r.val);
        assertEquals(3, r.next.val);
        assertEquals(1, r.next.next.next.val);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    /**
     * 迭代实现
     * O(n) O(1)
     * @param head
     * @return
     */
    public ListNode reverseListx(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;


    }




}





