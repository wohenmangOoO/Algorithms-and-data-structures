package com.liujin.code;
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
//k节点的组内逆序调整
public class Code13_ReverseNodesInKGroup {
    public static class ListNode{
        public int val;
        public ListNode next;

    }
    public static ListNode reverseKGroup(ListNode head,int k){
        ListNode start = head;
        ListNode end = getKGroupEnd(start,k);
        if (end == null){
            return head;
        }
        //第一组凑齐了
        head = end;
        reverse(start,end);
        //返回上一组结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null){
            start = lastEnd.next;
            end = getKGroupEnd(start,k);
            if (end == null){
                return head;
            }
            reverse(start,end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }
    public static ListNode getKGroupEnd(ListNode start, int k){
        while (--k != 0 && start != null){
            start = start.next;
        }
        return start;
    }
    public static void reverse(ListNode start, ListNode end){
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        while (cur != end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }


}
