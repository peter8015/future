package com.future.algorithm;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 反转链表II 区间内链表反转
 * <p>
 * 题目：给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置
 * left 到位置 right 的链表节点，返回 反转后的链表 。
 * input: [1,2,3,4,5]  2, 4
 * output: [1,4,3,2,5]
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author cliff
 */
public class ReverseBetween {

    @Test
    public void t1() throws Exception {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode r = reverseBetween3(l1, 2, 4);

        ListNode node = l1; // for print
        System.out.println();
        while(node != null) {
            System.out.print(String.format("%d->", node.val));
            node = node.next;
        }
        System.out.println();

//        1->2->3->4->5   1->4->3->2->5
        assertEquals(4, r.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(5, r.next.next.next.next.val);
    }

    /**
     * 解法一
     * 思路：根据left 和 right截取出子链表，并进行反转再对接到原链表中
     * [1,2,3,4,5] -> [1,4,3,2,5]
     * 时间复杂度：O(N)，其中N为链表总节点数。最坏情况下，需要遍历整个链表
     * 空间复杂度：O(1)，只使用了常数个变量。
     * 关键是画出截取后子链表的节点与新的链表的对应
     * prev->leftNode      rightNode -> curr
     */
    public ListNode reverseBetweenx(ListNode head, int left, int right) throws Exception {
        // add bound or exception logic
        if (head == null || head.next == null) return head;

        // add left and right pointer, and determine the position of the left and right pointer
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // add leftNode and curr pointer to store node, and cut List to get child
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        // reverse child list
        reverseLinkedList(leftNode);

        // get final result with docking list
        pre.next = rightNode;
        leftNode.next = cur;

        return dummyNode.next;
    }

    /**
     * Reverse listNode with recursive
     * O(n) O(n)
     *
     * @param head
     * @return ListNode
     */
    public ListNode reverseList(ListNode head) {
        // add bound or exception logic
        if (head == null || head.next == null) {
            return head;
        }
        // add recursive logic
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    // 迭代方案 O(n) O(1)
    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public ListNode reverseListBetweenT1(ListNode head, int left, int right) {
        // bound logic
        if (head == null || head.next == null) {
            return head;
        }

        // cut sub list and reverse
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode prev = dump;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;
        prev.next = null;
        rightNode.next = null;

        reverse(head);

        prev.next = rightNode;
        leftNode.next = curr;

        return dump.next;
    }

    public void reverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode prev = dump;
        for(int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode rightNode = prev;
        for(int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;

        prev.next = null;
        rightNode.next = null;

        reverse3(leftNode);

        prev.next = rightNode;
        leftNode.next = curr;

        return dump.next;
    }


    public ListNode reverse3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

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
