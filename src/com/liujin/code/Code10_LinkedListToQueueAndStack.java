package com.liujin.code;
public class Code10_LinkedListToQueueAndStack {
    //用单链表结构实现队列
    public static class Node<V>{
        public V value;
        public Node<V> next;
        public Node(V v){
            value = v;
            next =null;
        }
    }
    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;
        public MyQueue(){
            head = null;
            tail = null;
            size = 0;
        }
        public int size(){
            return size;
        }
        //放入一个元素
        public void offer(V value){
            Node<V> cur = new Node<>(value);
            if (tail == null){
                tail = cur;
                head = cur;
            }else {
                head.next = cur;
                tail = cur;
            }
            size ++;
        }
        //取出一个元素
        public V poll(){
            V ans = null;
            if (head != null){
                ans = head.value;
                head = head.next;
                size --;
            }
            if (head == null){
                tail = null;
            }
            return ans;
        }
        //读取数据
        public V peek(){
            V ans = null;
            if (head != null){
                ans =  head.value;
            }
            return ans;
        }

    }
    //用单链表结构实现栈
    public static class MyStack<V>{
        private Node<V> head;
        private int size;

        public MyStack(){
            head = null;
            size = 0;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int size(){
            return size;
        }
        //放入一个元素 push：放入
        public void push(V value){
            Node<V> cur = new Node<>(value);
            if (head == null){
                head = cur;
            }else {
                cur.next = head;
                head = cur;
            }
            size ++;
        }
        //取出一个元素 pop：取出
        public V pop(){
            V ans = null;
            if (head != null){
                ans = head.value;
                head = head.next;
                size --;
            }
            return ans;
        }

        //读取栈top元素
        public V peek(){
            return head != null ? head.value : null;
        }
    }


}
