// BOJ - 14912
// Problem Sheet - https://www.acmicpc.net/problem/14912

import java.io.*;

public class Main {

    private static int n, d;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        n = Integer.parseInt(row[0]);
        d = Integer.parseInt(row[1]);
        count = new int[10];
        br.close();
    }

    private static int solve() {
        for (int i=1 ; i<=n ; i++) {
            int value = i;
            while (value / 10 > 0) {
                count[value % 10]++;
                value /= 10;
            }
            count[value % 10]++;
        }
        return count[d];
    }

}