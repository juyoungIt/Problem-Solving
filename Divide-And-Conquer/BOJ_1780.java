// BOJ - 1780
// Problem Sheet - https://www.acmicpc.net/problem/1780

import java.io.*;

public class Main {

    private static int N;
    private static int[][] paper;
    private static final int[] paperCounts = new int[3];

    public static void main(String[] args) throws IOException {
        input();
        solve(N, 0, 0);
        System.out.printf("%d\n%d\n%d", paperCounts[0], paperCounts[1], paperCounts[2]);
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
        if (n == 1 || isUniqueValuePaper(n, x, y)) {
            paperCounts[paper[y][x] + 1]++;
            return;
        }
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                solve(n / 3, x + (n / 3) * j, y + (n / 3) * i);
            }
        }
    }

    private static boolean isUniqueValuePaper(int n, int x, int y) {
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
