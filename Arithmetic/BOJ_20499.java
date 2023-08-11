// BOJ - 20499
// Problem Sheet - https://www.acmicpc.net/problem/20499

import java.io.*;

public class Main {

    private static final String VALID = "gosu";
    private static final String INVALID = "hasu";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] kda = bf.readLine().split("/");

        int K = Integer.parseInt(kda[0]);
        int D = Integer.parseInt(kda[1]);
        int A = Integer.parseInt(kda[2]);

        System.out.println((K + A < D || D == 0) ? INVALID : VALID);

        bf.close();
        System.exit(0);
    }
}