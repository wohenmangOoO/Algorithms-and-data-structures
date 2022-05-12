package com.liujin.code;

import java.util.Comparator;
import java.util.PriorityQueue;

// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
//合并k个升序链表
public class Code18_MergeKSortedLists {
    public static class ListNode{
        public int val;
        public ListNode next;

    }
    //自定义比较器
    public static class ListNodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
    public static ListNode mergeKLists(ListNode [] lists){
        if (lists == null){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()){
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (pre.next != null){
                heap.add(pre.next);
            }
        }
        return head;
    }

}
