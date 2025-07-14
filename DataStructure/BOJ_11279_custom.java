// BOJ - 11279
// Problem Sheet - https://www.acmicpc.net/problem/11279

import java.io.*;

public class Main {

    static class MyPriorityQueue {
        int[] heap;
        int size;

        public MyPriorityQueue() {
            heap = new int[SIZE + 1];
            size = 0;
        }

        public void add(int x) {
            heap[++size] = x;
            int cur = size;
            while (cur > 1) {
                int parent = cur / 2;
                if (heap[parent] >= heap[cur]) break;
                swap(parent, cur);
                cur = parent;
            }
        }

        public int pop() {
            if (size == 0) return 0;
            int root = heap[1];
            heap[1] = heap[size--];
            int cur = 1;
            while (cur * 2 <= size) {
                int left = cur * 2;
                int right = left + 1;
                int child = (right <= size && heap[left] < heap[right]) ? right : left;
                if (heap[cur] >= heap[child]) break;
                swap(cur, child);
                cur = child;
            }
            return root;
        }

        private void swap(int idx1, int idx2) {
            int tmp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = tmp;
        }

    }

    static final int SIZE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyPriorityQueue pQueue = new MyPriorityQueue();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pQueue.pop()).append("\n");
            else pQueue.add(x);
        }
        System.out.println(sb);
        br.close();
    }
}