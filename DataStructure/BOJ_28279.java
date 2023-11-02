// BOJ - 28279
// Problem Sheet - https://www.acmicpc.net/problem/28279

import java.util.*;
import java.io.*;

public class Main {

    static class MyNode {

        private final int value;
        private MyNode next;
        private MyNode prev;

        public MyNode(int value, MyNode prev, MyNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getValue() { return this.value; }
        public MyNode getPrev() { return this.prev; }
        public MyNode getNext() { return this.next; }
        public void setNext(MyNode next) { this.next = next; }
        public void setPrev(MyNode prev) { this.prev = prev; }

    }

    static class MyLinkedList {

        private MyNode head;
        private MyNode tail;
        private int size;

        public MyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addFirst(int x) {
            if(this.head == null) {
                this.head = new MyNode(x, null, null);
                this.tail = this.head;
            } else {
                this.head.setPrev(new MyNode(x, null, head));
                this.head = this.head.getPrev();
            }
            this.size++;
        }

        public void addLast(int x) {
            if(this.head == null) {
                this.head = new MyNode(x, null, null);
                this.tail = this.head;
            } else {
                this.tail.setNext(new MyNode(x, tail, null));
                this.tail = this.tail.getNext();
            }
            this.size++;
        }

        public int removeFirst() {
            if(this.size == 0) {
                return -1;
            }
            int removed = this.head.getValue();
            this.head = this.head.getNext();
            if(this.head != null) {
                this.head.setPrev(null);
            } else {
                this.tail = null;
            }
            this.size--;
            return removed;
        }

        public int removeLast() {
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

        public int getFirst() {
            return this.head.getValue();
        }

        public int getLast() {
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

        public void pushFirst(int x) {
            this.storage.addFirst(x);
        }

        public void pushLast(int x) {
            this.storage.addLast(x);
        }

        public int popFirst() {
            return this.storage.removeFirst();
        }

        public int popLast() {
            return this.storage.removeLast();
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

        public int peekFirst() {
            if(this.storage.size() == 0) {
                return -1;
            }
            return this.storage.getFirst();
        }

        public int peekLast() {
            if(this.storage.size() == 0) {
                return -1;
            }
            return this.storage.getLast();
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
                myStack.pushFirst(Integer.parseInt(st.nextToken()));
            } else if(commandType == 2) {
                myStack.pushLast(Integer.parseInt(st.nextToken()));
            } else if(commandType == 3) {
                sb.append(myStack.popFirst()).append("\n");
            } else if(commandType == 4) {
                sb.append(myStack.popLast()).append("\n");
            } else if(commandType == 5) {
                sb.append(myStack.size()).append("\n");
            } else if(commandType == 6) {
                sb.append(myStack.isEmpty()).append("\n");
            } else if(commandType == 7) {
                sb.append(myStack.peekFirst()).append("\n");
            } else {
                sb.append(myStack.peekLast()).append("\n");
            }
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}