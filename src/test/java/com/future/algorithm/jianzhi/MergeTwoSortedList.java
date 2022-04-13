package com.future.algorithm.jianzhi;

import com.future.algorithm.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * offer25 合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新的链表节点仍然是递增排序的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4
 * <p>
 * 限制：
 * 0 =< 链表长度 <= 1000
 *
 * 分析：链表l1和l2是递增的，可以使用双指针遍历两链表，根据l1.val和l2.val确定链表的顺序，两节点指针交替进行，直至遍历完毕。
 * 时间复杂度： O(M+N)  M,N分别为两个链表的长度，合并操作需要遍历链表。
 * 空间复杂度： O(1)  节点引用r，curr使用常数大小的空间。
 */
public class MergeTwoSortedList {

    @Test
    public void t1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        ListNode r = mergeSortedList(n1, n4);

        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(4, r.next.next.next.next.next.val);
    }

    public ListNode mergeSortedList(ListNode n1, ListNode n2) {
        ListNode r = new ListNode(0);
        ListNode curr = r;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        curr.next = n1 != null ? n1 : n2;

        return r.next;
    }
}