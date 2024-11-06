// BOJ - 10866
// Problem Sheet - https://www.acmicpc.net/problem/10866

import java.util.*;
import java.io.*;

public class Main {

    private static final int DEQUE_SIZE = 1; // 제한하고 있는 Dequeue 의 크기를 상수로 분리

    /**
     * integer type value 만 다룰 수 있는 Dequeue 라고 가정함
     */
    interface CustomDeque {
        void pushFront(int value);
        void pushBack(int value);
        int popFront();
        int popBack();
        int size();
        boolean isEmpty();
        int getFront();
        int getBack();
    }

    /**
     * FixedArrayDeque
     * -> 고정된 배열을 기반으로 구현된 Deque
     * -> 한번 사이즈를 결정하면 변경할 수 없으며, 저장할 수 있는 원소 수에 제한이 있다
     */
    static class FixedArrayDeque implements CustomDeque {

        private final int[] storage;
        private final int capacity;
        private int frontIndex;
        private int backIndex;
        private int size;

        public FixedArrayDeque(int capacity) {
            storage = new int[capacity];
            frontIndex = -1;
            backIndex = -1;
            size = 0;
            this.capacity = capacity;
        }

        @Override
        public void pushFront(int value) {
            if (size == capacity) {
                throw new IllegalStateException("queue is full!...");
            }
            frontIndex = (frontIndex - 1 + capacity) % capacity;
            if (size == 0) {
                backIndex = frontIndex;
            }
            storage[frontIndex] = value;
            size++;
        }

        @Override
        public void pushBack(int value) {
            if (size == capacity) {
                throw new IllegalStateException("queue is full!...");
            }
            backIndex = (backIndex + 1) % capacity;
            if (size == 0) {
                frontIndex = backIndex;
            }
            storage[backIndex] = value;
            size++;
        }

        @Override
        public int popFront() {
            if (size == 0) {
                throw new IllegalStateException("queue is empty!...");
            }
            int value = storage[frontIndex];
            size--;
            if (size == 0) {
                frontIndex = -1;
                backIndex = -1;
            } else {
                frontIndex = (frontIndex + 1) % capacity;
            }
            return value;
        }

        @Override
        public int popBack() {
            if (size == 0) {
                throw new IllegalStateException("queue is empty!...");
            }
            int value = storage[backIndex];
            size--;
            if (size == 0) {
                frontIndex = -1;
                backIndex = -1;
            } else {
                backIndex = (backIndex - 1 + capacity) % capacity;
            }
            return value;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int getFront() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return storage[frontIndex];
        }

        @Override
        public int getBack() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return storage[backIndex];
        }
    }

    /**
     * DynamicArrayDeque
     * -> FixedArrayDeque 처럼 배열을 사용한다.
     * -> FixedArrayDeque 와 달리 배열의 사이즈를 동적으로 변경 및 할당하여 원소 수에 제한이 없다
     * -> 아직 불완전... Size Up 을 사용하는 경우 오류가 발생하고 있다
     */
    static class DynamicArrayDeque implements CustomDeque {

        private int[] storage;
        private int capacity;
        private int frontIndex;
        private int backIndex;
        private int size;

        public DynamicArrayDeque(int init) {
            storage = new int[init];
            frontIndex = -1;
            backIndex = -1;
            size = 0;
            capacity = init;
        }

        /**
         * 기존 스토리지 사이즈를 2배로 키움. 사이즈업 정도는 정책에 따라 달라질 수 있음
         */
        private void increaseCapacity() {
            int[] newStorage = new int[storage.length * 2];
            if (frontIndex <= backIndex) {
                // frontIndex가 rearIndex보다 작으면 연속된 배열 복사 가능
                System.arraycopy(storage, frontIndex, newStorage, 0, size);
            } else {
                // 원형 구조에 따라 배열이 나뉘어 저장된 경우
                int frontPartLength = capacity - frontIndex;
                System.arraycopy(storage, frontIndex, newStorage, 0, frontPartLength);
                System.arraycopy(storage, 0, newStorage, frontPartLength, backIndex + 1);
            }
            frontIndex = 0;
            backIndex = size - 1;
            storage = newStorage;
            capacity = newStorage.length;
        }

        @Override
        public void pushFront(int value) {
            if (size == capacity) {
                increaseCapacity();
            }
            frontIndex = (frontIndex - 1 + capacity) % capacity;
            if (size == 0) {
                backIndex = frontIndex;
            }
            storage[frontIndex] = value;
            size++;
        }

        @Override
        public void pushBack(int value) {
            if (size == capacity) {
                increaseCapacity();
            }
            backIndex = (backIndex + 1) % capacity;
            if (size == 0) {
                frontIndex = backIndex;
            }
            storage[backIndex] = value;
            size++;
        }

        @Override
        public int popFront() {
            if (size == 0) {
                throw new IllegalStateException("queue is empty!...");
            }
            int value = storage[frontIndex];
            size--;
            if (size == 0) {
                frontIndex = -1;
                backIndex = -1;
            } else {
                frontIndex = (frontIndex + 1) % capacity;
            }
            return value;
        }

        @Override
        public int popBack() {
            if (size == 0) {
                throw new IllegalStateException("queue is empty!...");
            }
            int value = storage[backIndex];
            size--;
            if (size == 0) {
                frontIndex = -1;
                backIndex = -1;
            } else {
                backIndex = (backIndex - 1 + capacity) % capacity;
            }
            return value;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int getFront() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return storage[frontIndex];
        }

        @Override
        public int getBack() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return storage[backIndex];
        }
    }

    /**
     * LinkedListDeque
     * -> LinkedList 구조를 기반으로 구현한 Deque
     * -> 저장하는 원소 수에 있어서 제한이 없다
     */
    static class LinkedListDeque implements CustomDeque {

        static class Node {
            private final int value;
            private Node prev;
            private Node next;

            public Node(int value) {
                this.value = value;
                this.prev = null;
                this.next = null;
            }

            public int getValue() { return this.value; }
            public Node getPrev() { return this.prev; }
            public Node getNext() { return this.next; }
            public void setPrev(Node prev) { this.prev = prev; }
            public void setNext(Node next) { this.next = next; }
        }

        private Node front;
        private Node back;
        private int size;

        public LinkedListDeque() {
            this.front = null;
            this.back = null;
            this.size = 0;
        }

        @Override
        public void pushFront(int value) {
            Node newNode = new Node(value);
            if (size == 0) {
                front = newNode;
                back = newNode;
            } else {
                front.setPrev(newNode);
                newNode.setNext(front);
                front = newNode;
            }
            size++;
        }

        @Override
        public void pushBack(int value) {
            Node newNode = new Node(value);
            if (size == 0) {
                front = newNode;
                back = newNode;
            } else {
                back.setNext(newNode);
                newNode.setPrev(back);
                back = newNode;
            }
            size++;
        }

        @Override
        public int popFront() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            Node node = front;
            Node newFront = front.getNext();
            if (newFront != null) {
                newFront.setPrev(null);
            }
            front = newFront;
            size--;
            return node.getValue();
        }

        @Override
        public int popBack() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            Node node = back;
            Node newBack = back.getPrev();
            if (newBack != null) {
                newBack.setNext(null);
            }
            back = newBack;
            size--;
            return node.getValue();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int getFront() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return front.getValue();
        }

        @Override
        public int getBack() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return back.getValue();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
//        CustomDeque deque = new FixedArrayDeque(DEQUE_SIZE);
//        CustomDeque deque = new DynamicArrayDeque(DEQUE_SIZE);
        CustomDeque deque = new LinkedListDeque();
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.popBack()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.getFront()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.getBack()).append("\n");
                    break;
                default:
                    throw new IllegalArgumentException("invalid command");
            }
        }

        System.out.println(sb);
        br.close();
    }
}