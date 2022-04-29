package com.future.algorithm;

import org.junit.jupiter.api.Test;

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

        ListNode node = reverseBetweenz(l1, 2, 4);
//        ListNode node = reverseBetweeny(l1, 2,4);
        assertEquals(4, node.next.val);
    }

    /**
     * 解法一
     * 思路：根据left 和 right截取出子链表，并进行反转再对接到原链表中
     * [1,2,3,4,5] -> [1,4,3,2,5]
     * 时间复杂度：O(N)，其中N为链表总节点数。最坏情况下，需要遍历整个链表
     * 空间复杂度：O(1)，只使用了常数个变量。
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
        reverseList(leftNode);

        // get final result with docking list
        pre.next = rightNode;
        leftNode.next = cur;

        return dummyNode.next;
    }

    /**
     * Reverse listNode with recursive
     * O(n) O(n)
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


    public ListNode reverseBetweenz(ListNode head, int left, int right) {
        // add bound and exception logic
        if(head == null || head.next == null) return head;
        if(left == 0 && right == 0) {
            reverseList(head);
        }

        //init and stores left/right pointer
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode rightNode = prev;
        for(int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // intercept list from left to right
        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;

        prev.next = null;
        rightNode.next = null;

        // reverse child list
        reverseList(leftNode);

        // docking original list
        prev.next = rightNode;
        leftNode.next = curr;

        return dummy.next;
    }

    /**
     * official solution
     */
    public ListNode reverseBetweeny(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

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

    //test reverse
    @Test
    public void t2() {
        //test reverse list
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reverseList(l1);
//        reverseLinkedList(l1);  //原地反转
        ListNode head = l5;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        assertEquals(5, l5.val);
        assertEquals(4, l5.next.val);
    }

}
