// BOJ - 10828
// Problem Sheet - https://www.acmicpc.net/problem/10828

import java.io.*;

public class Main {

    private static final int STACK_SIZE = 1;

    /**
     * CustomStack interface
     * -> integer type 을 다루는 stack 임을 가정한다
     */
    interface CustomStack {
        void push(int value);
        int pop();
        int size();
        boolean empty();
        int top();
    }

    /**
     * FixedArrayStack
     * -> 고정된 배열을 기반으로 구현된 Stack
     * -> 한번 사이즈를 결정하면 변경할 수 없으며, 저장할 수 있는 원소 수에 제한이 있다
     */
    static class FixedArrayStack implements CustomStack {

        private final int[] storage;
        private final int capacity;
        private int topIndex;

        public FixedArrayStack(int capacity) {
            this.storage = new int[capacity];
            this.capacity = capacity;
            this.topIndex = -1;
        }

        @Override
        public void push(int value) {
            if (topIndex + 1 == capacity) {
                throw new IllegalStateException("stack is full!...");
            }
            storage[++topIndex] = value;
        }

        @Override
        public int pop() {
            if (topIndex + 1 == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            return storage[topIndex--];
        }

        @Override
        public int size() {
            return topIndex + 1;
        }

        @Override
        public boolean empty() {
            return topIndex + 1 == 0;
        }

        @Override
        public int top() {
            if (topIndex + 1 == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            return storage[topIndex];
        }
    }

    /**
     * DynamicArrayStack
     * -> FixedArrayStack 처럼 내부적으로 배열을 사용한다
     * -> FixedArrayStack 와 달리 배열의 사이즈를 동적으로 변경 및 할당하여 원소 수에 제한이 없다
     */
    static class DynamicArrayStack implements CustomStack {

        private int[] storage;
        private int capacity;
        private int topIndex;

        public DynamicArrayStack(int capacity) {
            this.storage = new int[capacity];
            this.capacity = capacity;
            this.topIndex = -1;
        }

        @Override
        public void push(int value) {
            if (topIndex + 1 == capacity) {
                increaseCapacity();
            }
            storage[++topIndex] = value;
        }

        @Override
        public int pop() {
            if (topIndex + 1 == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            return storage[topIndex--];
        }

        @Override
        public int size() {
            return topIndex + 1;
        }

        @Override
        public boolean empty() {
            return topIndex + 1 == 0;
        }

        @Override
        public int top() {
            if (topIndex + 1 == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            return storage[topIndex];
        }

        private void increaseCapacity() {
            int[] newStorage = new int[storage.length * 2];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
            capacity = newStorage.length;
        }
    }

    /**
     * LinkedListStack
     * -> LinkedList 구조를 기반으로 구현한 Stack
     * -> 저장하는 원소 수에 있어서 제한이 없다
     */
    static class LinkedListStack implements CustomStack {

        static class Node {
            private final int value;
            private final Node prev;

            public Node(int value, Node prev) {
                this.value = value;
                this.prev = prev;
            }

            public int getValue() { return this.value; }
            public Node getPrev() { return this.prev; }
        }

        private Node topNode;
        private int size;

        public LinkedListStack() {
            this.topNode = null;
            this.size = 0;
        }

        @Override
        public void push(int value) {
            topNode = new Node(value, topNode);
            size++;
        }

        @Override
        public int pop() {
            if (size == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            Node node = topNode;
            topNode = node.getPrev();
            size--;
            return node.getValue();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean empty() {
            return size == 0;
        }

        @Override
        public int top() {
            if (size == 0) {
                throw new IllegalStateException("stack is empty!...");
            }
            return topNode.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
//        CustomStack stack = new FixedArrayStack(STACK_SIZE);
//        CustomStack stack = new DynamicArrayStack(STACK_SIZE);
        CustomStack stack = new LinkedListStack();
        while (N-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    int value = Integer.parseInt(command[1]);
                    stack.push(value);
                    break;
                case "pop":
                    sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.empty() ? -1 : stack.top()).append("\n");
                    break;
                default:
                    throw new IllegalArgumentException("invalid command...");
            }
        }

        System.out.println(sb);
        br.close();
    }
}