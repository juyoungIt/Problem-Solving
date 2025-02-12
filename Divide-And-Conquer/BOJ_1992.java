// BOJ - 1992
// Problem Sheet - https://www.acmicpc.net/problem/1992

import java.io.*;

public class Main {

    private static int N;
    private static int[][] video;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve(N, 0, 0);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i=0 ; i<N ; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j=0 ; j<N ; j++) {
                video[i][j] = row[j] - '0';
            }
        }
        br.close();
    }

    private static void solve(int n, int x, int y) {
        if (n == 1 || isOneColor(n, x, y)) {
            sb.append(video[y][x]);
            return;
        }
        sb.append("(");
        solve(n / 2, x, y);
        solve(n / 2, x + n / 2, y);
        solve(n / 2, x, y + n / 2);
        solve(n / 2, x + n / 2, y + n / 2);
        sb.append(")");
    }

    private static boolean isOneColor(int n, int x, int y) {
        int startColor = video[y][x];
        for (int i=y ; i<y+n ; i++) {
            for (int j=x ; j<x+n ; j++) {
                if (video[i][j] != startColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
