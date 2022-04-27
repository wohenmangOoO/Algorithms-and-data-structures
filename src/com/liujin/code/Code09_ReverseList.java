package com.liujin.code;
//链表反转
public class Code09_ReverseList {
    //单链表
    public static class Node{
        public int value;
        public Node next;
        public Node(int date){
            value = date;
        }
    }
    //单链表反转
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
    }
    //双链表
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int date){
            value = date;
        }
    }
    //双链表反转
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
//        n1 = reverseLinkedList(n1);
        DoubleNode n2 = new DoubleNode(1);
        n2.next = new DoubleNode(2);
        n2.next.next = new DoubleNode(3);
        n2.last = n2.last=null;
//        n2.last = n2
        while (n1 != null){
            System.out.print(n1.value + " ");
            n1 = n1.next;
        }
        System.out.println();

    }
}
