package com.future.algorithm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    public void t1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode r = reverse(l1);

        assertEquals(3, r.val);
        assertEquals(2, r.next.val);
        assertEquals(1, r.next.next.val);
    }

    /**
     * Recursion
     * 思想：
     * 时间复杂度：O(n)，其中n为链表的长度。需要对链表的第一个节点进行反转。
     * 空间复杂度：O(n)，其中n为链表的长度。空间复杂度取决于递归调用的栈空间，最多为n层。
     */
    public ListNode reversex(ListNode head) {
        //Recursion end condition
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    /**
     * iteration
     * 思路：在遍历链表时，将当前节点的next指针指向前一节点，由于当前节点没有引用下一个节点，所以需要提前将下一个节点存储起来。
     * 在更改引用之前还需要修改下一个节点，最后返回新的逆流而上引用 。
     * 时间复杂度：O(n)，n为链表的长度，只遍历一次。
     * 空间复杂度：O(1)
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Test
    public void t2() {
        String s = null;
        if(null != s) {
            System.out.println("1234");
        }
    }


    @Test
    public void t3() {



    }
}