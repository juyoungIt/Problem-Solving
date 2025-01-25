// BOJ - 7946
// Problem Sheet - https://www.acmicpc.net/problem/7946

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int d = Integer.parseInt(br.readLine());
        for (int i=0 ; i<d ; i++) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int k = Integer.parseInt(row[1]);
            int[] payments = new int[n];
            row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                payments[j] = Integer.parseInt(row[j]);
            }
            Arrays.sort(payments);
            sb.append(payments[k - 1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}