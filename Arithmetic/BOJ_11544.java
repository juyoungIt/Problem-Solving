// BOJ - 11544
// Problem Sheet - https://www.acmicpc.net/problem/11544

import java.io.*;

public class Main {

    private static int n, m;
    private static int[] budgets;
    private static int[][] selections;
    private static final int[] cards = { 1, 10, 100, 1_000, 10_000 };

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        m = Integer.parseInt(row[1]);
        budgets = new int[m];
        selections = new int[m][n];
        for (int i=0 ; i<m ; i++) {
            row = br.readLine().split(" ");
            budgets[i] = Integer.parseInt(row[0]);
            for (int j=1 ; j<=n ; j++) {
                selections[i][j - 1] = Integer.parseInt(row[j]);
            }
        }
        br.close();
    }

    private static int solve() {
        int originSum = 0;
        int maxSum = 0;
        for (int i=0 ; i<m ; i++) {
            int sum = 0;
            for (int j=0 ; j<n ; j++) {
                sum += selections[i][j];
            }
            if (sum <= budgets[i]) {
                originSum += selections[i][0];
            }
            sum -= selections[i][0];
            for (int j=4 ; j>=0 ; j--) {
                sum += cards[j];
                if (sum <= budgets[i]) {
                    maxSum += cards[j];
                    break;
                }
                sum -= cards[j];
            }
        }
        return maxSum - originSum;
    }

}