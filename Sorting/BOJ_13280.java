// BOJ - 13280
// Problem Sheet - https://www.acmicpc.net/problem/13280

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[] arr = new int[n];
            String[] row = br.readLine().split(" ");
            for (int i=0 ; i<n ; i++) {
                arr[i] = Integer.parseInt(row[i]);
            }
            Arrays.sort(arr);

            int minDiff = 1_000_001;
            for (int i=1 ; i<n ; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            sb.append(minDiff).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}