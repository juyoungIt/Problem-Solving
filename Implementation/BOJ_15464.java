// BOJ - 15464
// Problem Sheet - https://www.acmicpc.net/problem/15464

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            seq[i] = Integer.parseInt(row[i]);
        }
        int[] cows = new int[n];
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            cows[i] = Integer.parseInt(row[i]);
        }

        for (int i=0 ; i<3 ; i++) {
            int[] tmp = new int[n];
            for (int j=0 ; j<n ; j++) {
                tmp[j] = cows[seq[j] - 1];
            }
            System.arraycopy(tmp, 0, cows, 0, n);
        }

        for (int i=0 ; i<n ; i++) {
            sb.append(cows[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}