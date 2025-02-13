// BOJ - 2448
// Problem Sheet - https://www.acmicpc.net/problem/2448

import java.io.*;

public class Main {

    private static int N;
    private static char[][] pattern;

    public static void main(String[] args) throws IOException {
        input();
        solve(N, N-1, 0);
        System.out.println(getPattern());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pattern = new char[N][N * 2];
        br.close();
    }

    private static void solve(int n, int x, int y) {
        if (n == 3) {
            pattern[y][x] = '*';
            pattern[y+1][x-1] = '*';
            pattern[y+1][x+1] = '*';
            pattern[y+2][x-2] = '*';
            pattern[y+2][x-1] = '*';
            pattern[y+2][x] = '*';
            pattern[y+2][x+1] = '*';
            pattern[y+2][x+2] = '*';
            return;
        }
        solve(n / 2, x, y);
        solve(n / 2, x - n / 2, y + n / 2);
        solve(n / 2, x + n / 2, y + n / 2);
    }

    private static String getPattern() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N*2 ; j++) {
                sb.append(pattern[i][j] == 0 ? ' ' : pattern[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
