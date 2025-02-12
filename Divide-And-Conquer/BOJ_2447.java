// BOJ - 2447
// Problem Sheet - https://www.acmicpc.net/problem/2447

import java.io.*;

public class Main {

    private static int N;
    private static char[][] pattern;

    public static void main(String[] args) throws IOException {
        input();
        solve(N, 0, 0, false);
        System.out.println(printStar());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pattern = new char[N][N];
        br.close();
    }

    private static void solve(int n, int x, int y, boolean isEmpty) {
        if (n == 3) {
            for (int i=y ; i<y+n ; i++) {
                for (int j=x ; j<x+n ; j++) {
                    if (isEmpty) {
                        pattern[i][j] = ' ';
                        continue;
                    }
                    if (i == y + n / 3 && j == x + n / 3) {
                        pattern[i][j] = ' ';
                    } else {
                        pattern[i][j] = '*';
                    }
                }
            }
            return;
        }
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                solve(n / 3, x + n / 3 * j, y + n / 3 * i, (i == 1 && j == 1) ? true : isEmpty);
            }
        }
    }

    private static String printStar() {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}