// BOJ - 2630
// Problem Sheet - https://www.acmicpc.net/problem/2630

import java.io.*;

public class Main {

    private static int N;
    private static int[][] paper;
    private static final int[] paperCount = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        solve(N, 0, 0);
        System.out.printf("%d\n%d", paperCount[0], paperCount[1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i=0 ; i<N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<N ; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static void solve(int n, int x, int y) {
        if (n == 1 || isUniqueColorPaper(n, x, y)) {
            paperCount[paper[y][x]]++;
            return;
        }
        solve(n / 2, x, y);
        solve(n / 2, x + n / 2, y);
        solve(n / 2, x, y + n / 2);
        solve(n / 2, x + n / 2, y + n / 2);
    }

    private static boolean isUniqueColorPaper(int n, int x, int y) {
        for (int i=y ; i<y+n ; i++) {
            for (int j=x ; j<x+n ; j++) {
                if (paper[y][x] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
