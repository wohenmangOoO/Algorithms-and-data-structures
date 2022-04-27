package com.liujin.code;
//用双向链表结构实现双端队列
public class Code11_DoubleLinkedListToDeque {

    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v) {
            value = v;
            last = null;
            next = null;
        }
    }
    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int size(){
            return size;
        }
        public void pushHead(V value){
            Node<V> cur = new Node<>(value);
            if (head != null){
                cur.next = head;
                head.last = cur;
                head = cur;
            }else {
                head = cur;
                tail = cur;
            }
            size ++;
        }
        public void pushTail(V value){
            Node<V> cur = new Node<>(value);
            if (head == null){
                head = cur;
                tail = cur;
            }else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size ++;
        }
        public V pollHead(){
            V ans = null;
            if (head == null){
                return ans;
            }
            size --;
            ans = head.value;
            if (head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }
        public V pollTail(){
            V ans = null;
            if (head == null){
                return ans;
            }
            size --;
            ans = tail.value;
            if (head == tail){
                head = null;
                tail = null;
            }else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }
        public V peekHead(){
            V ans = null;
            if (head != null){
                ans = head.value;
            }
            return ans;
        }
        public V peekTail(){
            V ans = null;
            if (tail != null){
                ans = tail.value;
            }
            return ans;
        }

    }
}
