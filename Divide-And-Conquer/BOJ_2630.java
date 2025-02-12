// BOJ - 2630
// Problem Sheet - https://www.acmicpc.net/problem/2630

import java.io.*;

public class Main {

    private static int N;
    private static int[][] paper;
    private static int[][] acc;
    private static final int[] paperCount = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        solve(N, 1, 1);
        System.out.printf("%d\n%d", paperCount[0], paperCount[1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N + 1][N + 1];
        acc = new int[N + 1][N + 1];
        for (int i=1 ; i<=N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1 ; j<=N ; j++) {
                paper[i][j] = Integer.parseInt(row[j - 1]);
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + paper[i][j];
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
        int x1 = x, y1 = y;
        int x2 = x + n - 1, y2 = y + n - 1;
        int status = acc[y2][x2] - acc[y1 - 1][x2] - acc[y2][x1 - 1] + acc[y1 - 1][x1 - 1];
        return status == 0 || status == n * n;
    }
}
