// BOJ - 28278
// Problem Sheet - https://www.acmicpc.net/problem/28278

import java.util.*;
import java.io.*;

public class Main {

    static class MyNode {

        private final int value;
        private MyNode next;
        private final MyNode prev;

        public MyNode(int value, MyNode prev) {
            this.value = value;
            this.prev = prev;
            this.next = null;
        }

        public int getValue() { return this.value; }
        public MyNode getPrev() { return this.prev; }
        public MyNode getNext() { return this.next; }
        public void setNext(MyNode next) { this.next = next; }

    }

    static class MyLinkedList {

        private MyNode head;
        private MyNode tail;
        private int size;

        public MyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(int x) {
            if(this.head == null) {
                this.head = new MyNode(x, null);
                this.tail = this.head;
            } else {
                this.tail.setNext(new MyNode(x, tail));
                this.tail = this.tail.getNext();
            }
            this.size++;
        }

        public int remove() {
            if(this.size == 0) {
                return -1;
            }
            int removed = this.tail.getValue();
            this.tail = this.tail.getPrev();
            if(this.tail != null) {
                this.tail.setNext(null);
            } else {
                this.head = null;
            }
            this.size--;
            return removed;
        }

        public int getTail() {
            return this.tail.getValue();
        }

        public int size() {
            return this.size;
        }

    }

    static class MyStack {

        private final MyLinkedList storage;

        public MyStack() {
            this.storage = new MyLinkedList();
        }

        public void push(int x) {
            this.storage.add(x);
        }

        public int pop() {
            return this.storage.remove();
        }

        public int size() {
            return this.storage.size;
        }

        public int isEmpty() {
            if(this.storage.size() == 0) {
                return 1;
            }
             return 0;
        }

        public int peek() {
            if(this.storage.size() == 0) {
                return -1;
            }
            return this.storage.getTail();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        MyStack myStack = new MyStack();

        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int commandType = Integer.parseInt(st.nextToken());
            if(commandType == 1) {
                myStack.push(Integer.parseInt(st.nextToken()));
            } else if(commandType == 2) {
                sb.append(myStack.pop()).append("\n");
            } else if(commandType == 3) {
                sb.append(myStack.size()).append("\n");
            } else if(commandType == 4) {
                sb.append(myStack.isEmpty()).append("\n");
            } else {
                sb.append(myStack.peek()).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}