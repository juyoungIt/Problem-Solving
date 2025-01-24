// BOJ - 1991
// Problem Sheet - https://www.acmicpc.net/problem/1991

import java.io.*;

public class Main {

    private static int N;
    private static Node[] bt;
    private static StringBuilder buffer;

    static class Node {
        private final char name;
        private Node leftChild;
        private Node rightChild;

        public Node(char name) {
            this.name = name;
        }

        public char getName() { return this.name; }
        public Node getLeftChild() { return this.leftChild; }
        public Node getRightChild() { return this.rightChild; }
        public void setLeftChild(Node leftChild) { this.leftChild = leftChild; }
        public void setRightChild(Node rightChild) { this.rightChild = rightChild; }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + name +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bt = new Node[N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            char parent = row[0].charAt(0);
            char leftChild = row[1].charAt(0);
            char rightChild = row[2].charAt(0);
            if (bt[parent - 'A'] == null) {
                bt[parent - 'A'] = new Node(parent);
            }
            if (leftChild != '.') {
                if (bt[leftChild - 'A'] == null) {
                    bt[leftChild - 'A'] = new Node(leftChild);
                }
                bt[parent - 'A'].setLeftChild(bt[leftChild - 'A']);
            }
            if (rightChild != '.') {
                if (bt[rightChild - 'A'] == null) {
                    bt[rightChild - 'A'] = new Node(rightChild);
                }
                bt[parent - 'A'].setRightChild(bt[rightChild - 'A']);
            }
        }
        buffer = new StringBuilder();
        br.close();
    }

    private static String solve() {
        preorderTraversal(bt[0]);
        buffer.append("\n");
        inorderTraversal(bt[0]);
        buffer.append("\n");
        postorderTraversal(bt[0]);
        buffer.append("\n");
        return buffer.toString();
    }

    private static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        buffer.append(root.getName());
        preorderTraversal(root.getLeftChild());
        preorderTraversal(root.getRightChild());
    }

    private static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.getLeftChild());
        buffer.append(root.getName());
        inorderTraversal(root.getRightChild());
    }

    private static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.getLeftChild());
        postorderTraversal(root.getRightChild());
        buffer.append(root.getName());
    }

}