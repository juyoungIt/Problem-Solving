// BOJ - 9466
// Problem Sheet - https://www.acmicpc.net/problem/9466

import java.io.*;

public class Main {

    private static int[] graph, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            depth = new int[n + 1];
            String[] row = br.readLine().split(" ");
            for (int i=1 ; i<=n ; i++) {
                graph[i] = Integer.parseInt(row[i - 1]);
            }
            int cycleNodeCount = 0;
            for (int i=1 ; i<=n ; i++) {
                if (depth[i] == 0) {
                    depth[i] = 1;
                    cycleNodeCount += dfs(i);
                }
            }
            sb.append(n - cycleNodeCount).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int dfs(int sv) {
        int cycleNodeCount;
        if (depth[graph[sv]] == 0) {
            depth[graph[sv]] = depth[sv] + 1;
            cycleNodeCount = dfs(graph[sv]);
        } else {
            cycleNodeCount = depth[sv] - depth[graph[sv]] + 1;
        }
        depth[sv] = 100_001;
        return Math.max(cycleNodeCount, 0);
    }
}