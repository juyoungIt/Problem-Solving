// BOJ - 1629
// Problem Sheet - https://www.acmicpc.net/problem/1629

import java.io.*;

public class Main {

    private static int A, B, C;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(A, B));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        A = Integer.parseInt(row[0]);
        B = Integer.parseInt(row[1]);
        C = Integer.parseInt(row[2]);
        br.close();
    }

    private static long solve(int a, int b) {
        if (b == 1) {
            return a % C;
        }
        long divide = solve(a, b/2);
        if (b % 2 == 0) {
            return (divide * divide) % C;
        } else {
            return (((divide * divide) % C) * a) % C;
        }
    }
}
