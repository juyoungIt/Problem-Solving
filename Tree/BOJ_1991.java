// BOJ - 1991
// Problem Sheet - https://www.acmicpc.net/problem/1991

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] bt;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bt = new int[N][2];
        for (int i=0 ; i<N ; i++) {
            Arrays.fill(bt[i], -1);
        }
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            char parent = row[0].charAt(0);
            char left = row[1].charAt(0);
            char right = row[2].charAt(0);
            if (left != '.') bt[parent - 'A'][0] = left - 'A';
            if (right != '.') bt[parent - 'A'][1] = right - 'A';
        }
        sb = new StringBuilder();
        br.close();
    }

    private static void solve() {
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        sb.append("\n");
    }

    private static void preorder(int root) {
        if (root < 0) {
            return;
        }
        sb.append((char) (root + 'A'));
        preorder(bt[root][0]);
        preorder(bt[root][1]);
    }

    private static void inorder(int root) {
        if (root < 0) {
            return;
        }
        inorder(bt[root][0]);
        sb.append((char) (root + 'A'));
        inorder(bt[root][1]);
    }

    private static void postorder(int root) {
        if (root < 0) {
            return;
        }
        postorder(bt[root][0]);
        postorder(bt[root][1]);
        sb.append((char) (root + 'A'));
    }

}