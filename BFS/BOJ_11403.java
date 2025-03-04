// BOJ - 11403
// Problem Sheet - https://www.acmicpc.net/problem/11403

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] am;
    private static int[][] answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        am = new int[N][N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<N ; j++) {
                am[i][j] = Integer.parseInt(row[j]);
            }
        }
        answer = new int[N][N];
        visited = new boolean[N];
        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            visited = new boolean[N];
            bfs(i);
        }
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void bfs(int sv) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sv);
        while (!queue.isEmpty()) {
            for (int i=0 ; i<N ; i++) {
                if (visited[i] || am[queue.peek()][i] == 0) continue;
                queue.add(i);
                visited[i] = true;
                answer[queue.peek()][i] = 1;
                answer[sv][i] = 1;
            }
            queue.poll();
        }
    }

}