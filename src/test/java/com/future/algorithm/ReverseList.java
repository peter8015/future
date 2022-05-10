package com.future.algorithm;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 反转链表 反转单链表
 * 题目：给定一个链表进行反转输出
 * input: [1,2,3,4]
 * output: [4,3,2,1]
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-by-leetcode-solution-jvs5/
 * @author cliff
 */
public class ReverseList {

    @Test
    public void t1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        reverseT1(n1);

        // 1. null & negative & largest &smallest
        assertNull(null);
        // use case
        assertEquals(3, n4.next.val);
        assertEquals(2, n4.next.next.val);
    }

    /**
     * 解法一：递归实现
     * <p>
     * 时间复杂度：O(n)，其中n为链表长度，需要对链表的每个节点进行反转操作。
     * 空间复杂度：O(n)，其中n为链表长度。递归主要取决于调用栈空间，最多为n层。
     */
    public ListNode reverseList(ListNode head) {
        //add bound and exception logic and final condition
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    /**
     * 解法二：迭代实现。在遍历链表时，需要将当前节点的指针指向前一个节点，因此事先必须保存前一个节点。
     * 在更改引用之前，还需要存储后一个节点。
     * 时间复杂度：O(n)，其中n为链表长度，只需要遍历一次链表即可。
     * 空间复杂度：O(1)
     *
     * 1. big data?
     * 2. special scene data?
     * 3. other risk?
     * 4. test case?
     */
    public ListNode reverseListx(ListNode head) {
        // add bound and exception logic
        if(head == null || head.next == null) return head;

        // store prev and curr pointer
        ListNode prev = null;
        ListNode curr = head;

        // perform list reverse operation
        while(curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public ListNode reverseT1(ListNode head) {
        System.out.println("时间复杂度为O(n), 空间复杂度为O(1)");
        if(head == null || head.next == null) {
            return head;
        }

        //1->2->3->4  1<- 2<- 3<- 4
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}



