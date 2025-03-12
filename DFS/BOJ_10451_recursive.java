// BOJ - 10451
// Problem Sheet - https://www.acmicpc.net/problem/10451

import java.io.*;

public class Main {

    private static int N;
    private static int[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            String[] row = br.readLine().split(" ");
            for (int i=1 ; i<=N ; i++) {
                graph[i] = Integer.parseInt(row[i - 1]);
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
            dfs(i);
            cycleCount++;
        }
        return cycleCount;
    }

    private static void dfs(int sv) {
        visited[sv] = true;
        if (!visited[graph[sv]]) {
            dfs(graph[sv]);
        }
    }
}