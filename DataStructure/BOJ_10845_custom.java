// BOJ - 10845
// Problem Sheet - https://www.acmicpc.net/problem/10845

import java.util.*;
import java.io.*;

public class Main {

    private static final int QUEUE_SIZE = 1; // 제한하고 있는 Queue 의 크기를 상수로 분리

    /**
     * integer type value 만 다룰 수 있는 Queue 라고 가정함
     */
    interface CustomQueue {
        void push(int value);
        int pop();
        int size();
        boolean isEmpty();
        int getFront();
        int getRear();
    }

    /**
     * FixedArrayQueue
     * -> 고정된 배열을 기반으로 구현된 Queue
     * -> 한번 사이즈를 결정하면 변경할 수 없으며, 저장할 수 있는 원소 수에 제한이 있다
     */
    static class FixedArrayQueue implements CustomQueue {

        private final int[] storage;
        private final int capacity;
        private int frontIndex;
        private int rearIndex;
        private int size;

        public FixedArrayQueue(int capacity) {
            storage = new int[capacity];
            frontIndex = 0;
            rearIndex = -1;
            size = 0;
            this.capacity = capacity;
        }

        @Override
        public void push(int value) {
            if (size == capacity) {
                throw new IllegalStateException("queue is full...");
            }
            rearIndex = ++rearIndex % capacity;
            storage[rearIndex] = value;
            size++;
        }

        @Override
        public int pop() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty...");
            }
            size--;
            int value = storage[frontIndex];
            frontIndex = ++frontIndex % capacity;
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
            return storage[frontIndex];
        }

        @Override
        public int getRear() {
            if (rearIndex < 0) {
                throw new IllegalArgumentException();
            }
            return storage[rearIndex];
        }

    }

    /**
     * DynamicArrayQueue
     * -> FixedArrayQueue 처럼 배열을 사용한다.
     * -> FixedArrayQueue 와 달리 배열의 사이즈를 동적으로 변경 및 할당하여 원소 수에 제한이 없다
     * -> 아직 불완전... Size Up 을 사용하는 경우 오류가 발생하고 있다
     */
    static class DynamicArrayQueue implements CustomQueue {

        private int[] storage;
        private int capacity;
        private int frontIndex;
        private int rearIndex;
        private int size;

        public DynamicArrayQueue(int init) {
            storage = new int[init];
            frontIndex = 0;
            rearIndex = -1;
            size = 0;
            capacity = init;
        }

        @Override
        public void push(int value) {
            if (size == capacity) {
                increaseCapacity();
            }
            rearIndex = ++rearIndex % capacity;
            storage[rearIndex] = value;
            size++;
        }

        @Override
        public int pop() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty...");
            }
            size--;
            int value = storage[frontIndex];
            frontIndex = ++frontIndex % capacity;
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
            return storage[frontIndex];
        }

        @Override
        public int getRear() {
            if (rearIndex < 0) {
                throw new IllegalArgumentException();
            }
            return storage[rearIndex];
        }

        /**
         * 기존 스토리지 사이즈를 2배로 키움. 사이즈업 정도는 정책에 따라 달라질 수 있음
         */
        private void increaseCapacity() {
            int[] newStorage = new int[storage.length * 2];
            if (frontIndex <= rearIndex) {
                // frontIndex가 rearIndex보다 작으면 연속된 배열 복사 가능
                System.arraycopy(storage, frontIndex, newStorage, 0, size);
            } else {
                // 원형 구조에 따라 배열이 나뉘어 저장된 경우
                int frontPartLength = capacity - frontIndex;
                System.arraycopy(storage, frontIndex, newStorage, 0, frontPartLength);
                System.arraycopy(storage, 0, newStorage, frontPartLength, rearIndex + 1);
            }
            frontIndex = 0;
            rearIndex = size - 1;
            storage = newStorage;
            capacity = newStorage.length;
        }
    }

    /**
     * LinkedListQueue
     * -> LinkedList 구조를 기반으로 구현한 Queue
     * -> 저장하는 원소 수에 있어서 제한이 없다
     */
    static class LinkedListQueue implements CustomQueue {

        static class Node {
            private final int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }

            public int getValue() { return this.value; }
            public Node getNext() { return this.next; }
            public void setNext(Node next) { this.next = next; }
        }

        private Node front;
        private Node rear;
        private int size;

        public LinkedListQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        @Override
        public void push(int value) {
            Node newNode = new Node(value);
            if (size == 0) {
                front = newNode;
            } else {
                rear.setNext(newNode);
            }
            rear = newNode;
            size++;
        }

        @Override
        public int pop() {
            if (size == 0) {
                throw new NoSuchElementException("queue is empty!...");
            }
            Node node = front;
            front = node.getNext();
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
            if (front == null) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return front.getValue();
        }

        @Override
        public int getRear() {
            if (rear == null) {
                throw new NoSuchElementException("queue is empty!...");
            }
            return rear.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
//        CustomQueue queue = new FixedArrayQueue(QUEUE_SIZE);
//        CustomQueue queue = new DynamicArrayQueue(QUEUE_SIZE);
        CustomQueue queue = new LinkedListQueue();
        while (N-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    int value = Integer.parseInt(command[1]);
                    queue.push(value);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.getFront()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.getRear()).append("\n");
                    break;
                default:
                    throw new IllegalArgumentException("invalid command...");
            }
        }

        System.out.println(sb);
        br.close();
    }
}