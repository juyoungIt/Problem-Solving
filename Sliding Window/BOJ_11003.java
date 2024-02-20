// BOJ - 11003
// Problem Sheet - https://www.acmicpc.net/problem/11003

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return this.index; }
        public int getValue() { return this.value; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int curValue = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.peekLast().getValue() > curValue) {
                deque.pollLast();
            }
            deque.addLast(new Node(i, curValue));
            if(deque.getFirst().getIndex() <= i-l) {
                deque.pollFirst();
            }
            sb.append(deque.getFirst().getValue()).append(" ");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}