// BOJ - 5639
// Problem Sheet - https://www.acmicpc.net/problem/5639

import java.io.*;

public class Main {

    static class Node {
        private final int value;
        private Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
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
        postorder(root);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input == null) break;
            int value = Integer.parseInt(input);
            Node newNode = new Node(value, null, null);
            if (root == null) {
                root = newNode;
                continue;
            }
            addNode(root, newNode);
        }
        sb = new StringBuilder();
        br.close();
    }

    private static void addNode(Node parent, Node newNode) {
        if (parent == null) {
            return;
        }
        if (parent.getValue() > newNode.getValue()) {
            if (parent.getLeft() == null) {
                parent.setLeft(newNode);
            } else {
                addNode(parent.getLeft(), newNode);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(newNode);
            } else {
                addNode(parent.getRight(), newNode);
            }
        }
    }

    private static void postorder(Node root) {
        if (root == null) return;
        postorder(root.getLeft());
        postorder(root.getRight());
        sb.append(root.getValue()).append("\n");
    }
}