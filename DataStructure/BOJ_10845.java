// BOJ - 10845
// Problem Sheet - https://www.acmicpc.net/problem/10845

import java.util.*;
import java.io.*;

public class Main {

    static class MyQueue {
        private final int[] storage; // queue의 데이터를 저장하는 array
        private int storageSize; // 저장된 데이터의 수
        private int frontIdx; // queue의 front index
        private int rearIdx; // queue의 rear index

        public MyQueue(int size) {
            this.storage = new int[size];
            this.storageSize = 0;
            this.frontIdx = 0;
            this.rearIdx = 0;
        }

        private int getNextIdx(int curIdx) {
            if(curIdx == QUEUE_SIZE-1) {
                return 0;
            } else {
                return curIdx+1;
            }
        }

        private int getPrevIdx(int curIdx) {
            if(curIdx == 0) {
                return QUEUE_SIZE-1;
            } else {
                return curIdx-1;
            }
        }

        public void push(int number) {
            this.storage[this.rearIdx] = number;
            this.rearIdx = getNextIdx(this.rearIdx);
            storageSize++;
        }

        public int pop() {
            if(isEmpty() == 1) {
                return -1;
            }
            int number = getFront();
            this.frontIdx = getNextIdx(this.frontIdx);
            storageSize--;
            return number;
        }

        public int size() {
            return storageSize;
        }

        public int isEmpty() {
            if(this.frontIdx == this.rearIdx) {
                return 1;
            }
            return 0;
        }

        public int getFront() {
            if(isEmpty() == 1) {
                return -1;
            }
            return storage[this.frontIdx];
        }

        public int getRear() {
            if(isEmpty() == 1) {
                return -1;
            }
            return storage[getPrevIdx(this.rearIdx)];
        }
    }

    private static final int QUEUE_SIZE = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        MyQueue queue = new MyQueue(QUEUE_SIZE); // 데이터를 저장할 queue

        int n = Integer.parseInt(bf.readLine()); // 명령의 수
        for(int i=0 ; i<n ; i++) {
            String[] commands = bf.readLine().split(" "); // 명령어를 입력받음
            if(commands[0].equals("push")) {
                queue.push(Integer.parseInt(commands[1]));
            } else if(commands[0].equals("pop")) {
                System.out.println(queue.pop());
            } else if(commands[0].equals("size")) {
                System.out.println(queue.size());
            } else if(commands[0].equals("empty")) {
                System.out.println(queue.isEmpty());
            } else if(commands[0].equals("front")) {
                System.out.println(queue.getFront());
            } else { // back
                System.out.println(queue.getRear());
            }
        }

        bf.close();
        System.exit(0);
    }
}