// BOJ - 1325
// Problem Sheet - https://www.acmicpc.net/problem/1325

import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static List<Integer>[] network;
    private static int[] hackedCounts;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);
        network = new List[N + 1];
        for (int i=1 ; i<=N ; i++) {
            network[i] = new ArrayList<>();
        }
        for (int i=0 ; i<M ; i++) {
            row = br.readLine().split(" ");
            int A = Integer.parseInt(row[0]);
            int B = Integer.parseInt(row[1]);
            network[B].add(A);
        }
        hackedCounts = new int[N + 1];
        br.close();
    }

    private static String solve() {
        int maxHackedCount = -1;
        for (int i=1 ; i<=N ; i++) {
            int hackedCount = getHackedCount(i);
            hackedCounts[i] = hackedCount;
            maxHackedCount = Math.max(maxHackedCount, hackedCounts[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1 ; i<=N ; i++) {
            if (hackedCounts[i] == maxHackedCount) {
                sb.append(i).append(" ");
            }
        }
        return sb.toString();
    }

    private static int getHackedCount(int src) {
        int hackedCount = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] hacked = new boolean[N + 1];
        stack.push(src);
        hacked[src] = true;
        hackedCount++;
        while (!stack.isEmpty()) {
            boolean allConnected = true;
            for (int c : network[stack.peek()]) {
                if (hacked[c]) continue;
                stack.push(c);
                hacked[c] = true;
                hackedCount++;
                allConnected = false;
                break;
            }
            if (allConnected) stack.pop();
        }
        return hackedCount;
    }
}