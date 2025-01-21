// BOJ - 2841
// Problem Sheet - https://www.acmicpc.net/problem/2841

import java.util.*;
import java.io.*;

public class Main {

    private static int N, P;
    private static int[][] sheets;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        P = Integer.parseInt(row[1]);
        sheets = new int[N][2];
        for (int i=0 ; i<N ; i++) {
            row = br.readLine().split(" ");
            sheets[i][0] = Integer.parseInt(row[0]);
            sheets[i][1] = Integer.parseInt(row[1]);
        }
        br.close();
    }

    private static int solve() {
        int totalCount = 0;
        Stack<Integer>[] stacks = new Stack[N + 1];
        for (int[] sheet : sheets) {
            if (stacks[sheet[0]] == null) {
                stacks[sheet[0]] = new Stack<>();
            }
            while (!stacks[sheet[0]].isEmpty() && stacks[sheet[0]].peek() > sheet[1]) {
                stacks[sheet[0]].pop();
                totalCount++;
            }
            if (!stacks[sheet[0]].isEmpty() && stacks[sheet[0]].peek() == sheet[1]) continue;
            stacks[sheet[0]].push(sheet[1]);
            totalCount++;
        }
        return totalCount;
    }
}