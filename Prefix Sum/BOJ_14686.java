// BOJ - 14686
// Problem Sheet - https://www.acmicpc.net/problem/14686

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] accA = new int[n + 1];
        int[] accB = new int[n + 1];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            accA[i + 1] = accA[i] + Integer.parseInt(row[i]);
        }
        row = br.readLine().split(" ");
        for (int i=0 ; i<n ; i++) {
            accB[i + 1] = accB[i] + Integer.parseInt(row[i]);
        }
        int k = 0;
        for (int i=1 ; i<=n ; i++) {
            if (accA[i] == accB[i]) {
                k = i;
            }
        }
        System.out.println(k);
        br.close();
    }
}