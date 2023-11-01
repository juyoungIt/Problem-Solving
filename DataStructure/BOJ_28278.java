// BOJ - 28278
// Problem Sheet - https://www.acmicpc.net/problem/28278

import java.util.*;
import java.io.*;

public class Main {

    static class MyStack {

        private final int[] arr;

        private int size;

        public MyStack() {
            arr = new int[1_000_000];
            this.size = 0;
        }

        public void push(int x) {
            arr[size++] = x;
        }

        public int pop() {
            if(size == 0) {
                return -1;
            }
            return arr[--size];
        }

        public int size() {
            return this.size;
        }

        public int isEmpty() {
            if(size == 0) {
                return 1;
            }
            return 0;
        }

        public int peek() {
            if(size == 0) {
                return -1;
            }
            return arr[size - 1];
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