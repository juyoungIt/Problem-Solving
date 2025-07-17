// BOJ - 16148
// Problem Sheet - https://www.acmicpc.net/problem/16148

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String outputFormat = "Data Set %d:\n%d\n\n";
        int k = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=k ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] t = new int[n];
            String[] row = br.readLine().split(" ");
            for (int j=0 ; j<n ; j++) {
                t[j] = Integer.parseInt(row[j]);
            }
            Arrays.sort(t);
            int count = 0;
            for (int j=0 ; j<n ; j++) {
                if (t[j] > count) break;
                count++;
            }
            sb.append(String.format(outputFormat, i, count));
        }

        System.out.println(sb);
        br.close();
    }
}