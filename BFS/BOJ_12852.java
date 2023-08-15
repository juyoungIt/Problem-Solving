// BOJ - 12852
// Problem Sheet - https://www.acmicpc.net/problem/12852

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int value;

        private final String history;

        public Node(int value, String history) {
            this.value = value;
            this.history = history;
        }

        public int getValue() { return this.value; }
        public String getHistory() { return this.history; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, N + " "));
        String history = "";
        while(!queue.isEmpty()) {
            Node curNode = queue.peek();
            if(curNode.getValue() == 1) {
                history = curNode.getHistory();
                break;
            }
            if(curNode.getValue() % 3 == 0) {
                int value = curNode.getValue() / 3;
                queue.add(new Node(value, curNode.getHistory() + value + " "));
            }
            if(curNode.getValue() % 2 == 0) {
                int value = curNode.getValue() / 2;
                queue.add(new Node(value, curNode.getHistory() + value + " "));
            }
            int value = curNode.getValue() - 1;
            queue.add(new Node(value, curNode.getHistory() + value + " "));
            queue.poll();
        }

        System.out.println(history.split(" ").length - 1);
        System.out.println(history);

        bf.close();
        System.exit(0);
    }
}