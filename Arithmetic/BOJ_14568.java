// BOJ - 14568
// Problem Sheet - https://www.acmicpc.net/problem/14568

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int caseCount = 0;
        for (int i=1 ; n- 2 * i > 3 ; i++) {
            caseCount += (n - 2 * i - 2) / 2;
        }
        System.out.println(caseCount);

        br.close();
        System.exit(0);
    }
}