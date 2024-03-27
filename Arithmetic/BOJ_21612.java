// BOJ - 21612
// Problem Sheet - https://www.acmicpc.net/problem/21612

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(br.readLine());
        int p = 5 * b - 400;
        int valueIndex = Integer.compare(100, p);

        System.out.printf("%d\n%d", p, valueIndex);

        br.close();
        System.exit(0);
    }
}