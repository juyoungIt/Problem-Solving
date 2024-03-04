// BOJ - 27331
// Problem Sheet - https://www.acmicpc.net/problem/27331

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int digitA = Integer.parseInt(br.readLine());
        int digitB = Integer.parseInt(br.readLine());

        System.out.printf("%d%d\n", digitA, digitB);

        br.close();
        System.exit(0);
    }
}