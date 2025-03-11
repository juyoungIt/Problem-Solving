// BOJ - 10451
// Problem Sheet - https://www.acmicpc.net/problem/10451

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer>[] al;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            al = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i=1 ; i<=N ; i++) {
                al[i] = new ArrayList<>();
            }
            String[] row = br.readLine().split(" ");
            for (int i=1 ; i<=N ; i++) {
                al[i].add(Integer.parseInt(row[i - 1]));
            }
            sb.append(getCycleCount()).append("\n");
        }

        System.out.println(sb);
        br.close();
	}

    private static int getCycleCount() {
        int cycleCount = 0;
        for (int i=1 ; i<=N ; i++) {
            if (visited[i]) continue;
            if (isCycle(i, i)) {
                cycleCount++;
            }
        }
        return cycleCount;
    }

    private static boolean isCycle(int src, int next) {
        boolean isCycle = false;
        visited[next] = true;
        for (int n : al[next]) {
            if (n == src) {
                isCycle = true;
                break;
            }
            isCycle = isCycle(src, n);
        }
        return isCycle;
    }
}
