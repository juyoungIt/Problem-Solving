// BOJ - 2851
// Problem Sheet - https://www.acmicpc.net/problem/2851

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] acc = new int[11];
        for (int i=1 ; i<=10 ; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int minDiff = 1000;
        for (int i=1 ; i<11 ; i++) {
            int diff = acc[i] - 100;
            if (Math.abs(diff) < minDiff) {
                answer = acc[i];
                minDiff = Math.abs(diff);
            } else if (Math.abs(diff) == minDiff && diff > 0) {
                answer = acc[i];
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}