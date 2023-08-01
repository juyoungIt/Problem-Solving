// BOJ - 20492
// Problem Sheet - https://www.acmicpc.net/problem/20492

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int caseA = (int)(N * 0.78);
        int caseB = (int)(N - (N * 0.20 * 0.22));

        System.out.println(caseA + " " + caseB);

        bf.close();
        System.exit(0);
    }
}