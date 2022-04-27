package com.liujin.code;
//两个有序链表合并
// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code14_MergerTwoSortedLinkedList {
    public static class ListNode{
        public int val;
        public ListNode next;
    }
    public static ListNode mergerTwoSortedLinkedList(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre.next = pre.next;
        }
        pre = cur1 != null ? cur1 : cur2;
        return head;
    }
}
