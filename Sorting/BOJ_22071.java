// BOJ - 22071
// Problem Sheet - https://www.acmicpc.net/problem/22071

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] row = br.readLine().split(" ");
            int n = Integer.parseInt(row[0]);
            int l = Integer.parseInt(row[1]);
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int minSumOfA = 0, maxSumOfB = 0;
            for (int i=0 ; i<l ; i++) {
                minSumOfA += a[i];
                maxSumOfB += b[n - 1 - i];
            }
            sb.append(minSumOfA > maxSumOfB ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}