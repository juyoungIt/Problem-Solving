// BOJ - 11286
// Problem Sheet - https://www.acmicpc.net/problem/11286

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        private final int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() { return this.value; }

        @Override
        public int compareTo(Node node) {
            if(Math.abs(this.value) != Math.abs(node.getValue())) {
                return Integer.compare(Math.abs(this.value), Math.abs(node.getValue()));
            } else {
                return Integer.compare(this.value, node.getValue());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pQueue = new PriorityQueue<>();

        int n = Integer.parseInt(bf.readLine()); // 연산의 갯수
        for(int i=0 ; i<n ; i++) {
            int operation = Integer.parseInt(bf.readLine());
            if(operation == 0) {
                if(pQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pQueue.poll().getValue());
                }
            } else {
                pQueue.add(new Node(operation));
            }
        }

        bf.close();
        System.exit(0);
    }
}