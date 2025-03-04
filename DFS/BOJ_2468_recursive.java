// BOJ - 2468
// Problem Sheet - https://www.acmicpc.net/problem/2468

import java.io.*;

public class Main {

    private static int N;
    private static int[][] land;
    private static boolean[][] visited;
    private static int maxHeight = 0;

    private static final int[] xi = { -1, 1, 0, 0 };
    private static final int[] yi = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<N ; j++) {
                land[i][j] = Integer.parseInt(row[j]);
                maxHeight = Math.max(maxHeight, land[i][j]);
            }
        }
        br.close();
    }

    private static int solve() {
        int maxSafeAreaCount = 0;
        for (int h=0 ; h<=maxHeight ; h++) {
            int safeAreaCount = 0;
            visited = new boolean[N][N];
            for (int i=0 ; i<N ; i++) {
                for (int j=0 ; j<N ; j++) {
                    if (visited[i][j] || land[i][j] <= h) continue;
                    dfs(j, i, h);
                    safeAreaCount++;
                }
            }
            maxSafeAreaCount = Math.max(maxSafeAreaCount, safeAreaCount);
        }
        return maxSafeAreaCount;
    }

    private static void dfs(int sx, int sy, int h) {
        visited[sy][sx] = true;
        for (int i=0 ; i<4 ; i++) {
            int nx = sx + xi[i];
            int ny = sy + yi[i];
            if (isNotValid(nx, ny) || visited[ny][nx] || land[ny][nx] <= h) continue;
            dfs(nx, ny, h);
        }
    }

    private static boolean isNotValid(int x, int y) {
        return !(x>=0 && y>=0 && x<N && y<N);
    }

}