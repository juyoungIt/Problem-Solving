// BOJ - 5639
// Problem Sheet - https://www.acmicpc.net/problem/5639

import java.io.*;

public class Main {

    static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() { return this.value; }
        public Node getLeft() { return this.left; }
        public Node getRight() { return this.right; }
        public void setLeft(Node left) { this.left = left; }
        public void setRight(Node right) { this.right = right; }
    }

    private static Node root;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            int value = Integer.parseInt(input);
            if (root == null) {
                root = new Node(value);
                continue;
            }
            insertNode(root, value);
        }
        sb = new StringBuilder();
        br.close();
    }

    private static void solve() {
        postorder(root);
    }

    private static void insertNode(Node root, int value) {
        Node newNode = new Node(value);
        if (root == null) {
            return;
        }
        if (value < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            } else {
                insertNode(root.getLeft(), value);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(newNode);
            } else {
                insertNode(root.getRight(), value);
            }
        }
    }

    private static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.getLeft());
        postorder(root.getRight());
        sb.append(root.getValue()).append("\n");
    }
}