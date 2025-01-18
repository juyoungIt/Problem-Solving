// BOJ - 1184
// Problem Sheet - https://www.acmicpc.net/problem/1184

import java.io.*;

public class Main {

    private static int N;
    private static int[][] acc;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        acc = new int[N + 1][N + 1];
        for (int i=1 ; i<=N ; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=1 ; j<=N ; j++) {
                acc[i][j] = acc[i - 1][j]
                        + acc[i][j - 1]
                        - acc[i - 1][j - 1]
                        + Integer.parseInt(row[j - 1]);
            }
        }
        br.close();
    }

    private static int solve() {
        int answer = 0;
        for (int i=1 ; i<N ; i++) {
            for (int j=1 ; j<N ; j++) {
                answer += getValidCount(j, i);
            }
        }
        return answer;
    }

    private static int getValidCount(int x, int y) {
        int validCount = 0;
        for (int i=1 ; i<=y ; i++) {
            for (int j=1 ; j<=x ; j++) {
                for (int k=y+1 ; k<=N ; k++) {
                    for (int l=x+1 ; l<=N ; l++) {
                        if (getRevenue(j, i, x, y) == getRevenue(x + 1, y + 1, l, k)) {
                            validCount++;
                        }
                    }
                }
            }
        }
        for (int i=1 ; i<=y ; i++) {
            for (int j=x+1 ; j<=N ; j++) {
                for (int k=y+1 ; k<=N ; k++) {
                    for (int l=1 ; l<=x ; l++) {
                        if (getRevenue(x + 1, i, j, y) == getRevenue(l, y + 1, x, k)) {
                            validCount++;
                        }
                    }
                }
            }
        }
        return validCount;
    }

    private static int getRevenue(int x1, int y1, int x2, int y2) {
        return acc[y2][x2] - acc[y1 - 1][x2] - acc[y2][x1 - 1] + acc[y1 - 1][x1 - 1];
    }
}