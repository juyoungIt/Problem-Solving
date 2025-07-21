// BOJ - 11286
// Problem Sheet - https://www.acmicpc.net/problem/11286

import java.io.*;

public class Main {

    static class MyPriorityQueue {
        int[] heap;
        int size;

        public MyPriorityQueue(int range) {
            heap = new int[range + 1];
            size = 0;
        }

        public void add(int x) {
            heap[++size] = x;
            int cur = size;
            while (cur > 1) {
                int parent = cur / 2;
                if (compare(heap[parent], heap[cur]) <= 0) break;
                swap(parent, cur);
                cur = parent;
            }
        }

        public int poll() {
            if (size == 0) return 0;
            int root = heap[1];
            heap[1] = heap[size--];
            int cur = 1;
            while (cur * 2 <= size) {
                int left = cur * 2;
                int right = left + 1;
                int child = (compare(heap[left], heap[right]) > 0) ? right : left;
                if (compare(heap[cur], heap[child]) <= 0) break;
                swap(cur, child);
                cur = child;
            }
            return root;
        }

        private int compare(int a, int b) {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) {
                return a - b;
            }
            return absA - absB;
        }

        private void swap(int idx1, int idx2) {
            int tmp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        MyPriorityQueue pq = new MyPriorityQueue(n);
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) sb.append(pq.poll()).append("\n");
            else pq.add(x);
        }
        System.out.println(sb);
        br.close();
    }
}