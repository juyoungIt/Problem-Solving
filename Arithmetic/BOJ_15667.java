// BOJ - 15667
// Problem Sheet - https://www.acmicpc.net/problem/15667

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = 1;
        while(getTotalCnt(k) != n) {
            k++;
        }
        System.out.println(k);

        br.close();
        System.exit(0);
    }

    private static int getTotalCnt(int k) {
        return 1 + k + k * k;
    }
}