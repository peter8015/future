package com.future.algorithm.jianzhi;

import com.future.algorithm.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 题目：删除排序链表中的重复元素
 *      给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 分析：当 cur.val 和 cur.next.val 相等时说明需要去重，则将 cur 的下一个指针指向下一个的下一个，
 * 这样就能达到去重复的效果
 *
 * 时间复杂度： O(n)
 */
public class DeleteDuplicate {


    @Test
    public void t1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r = deleteDuplicates(n1);

        assertEquals(1, r.val);
        assertEquals(2, r.next.val);
        assertEquals(3, r.next.next.val);
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}