// BOJ - 30214
// Problem Sheet - https://www.acmicpc.net/problem/30214

import java.io.*;

public class Main {

    private static int s1, s2;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        s1 = Integer.parseInt(row[0]);
        s2 = Integer.parseInt(row[1]);
        br.close();
    }

    private static char solve() {
        return ((double)s2 / 2) <= s1 ? 'E' : 'H';
    }
}
