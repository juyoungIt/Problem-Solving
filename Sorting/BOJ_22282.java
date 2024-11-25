// BOJ - 22282
// Problem Sheet - https://www.acmicpc.net/problem/22282

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] citations = new int[n];
        for (int i=0 ; i<n ; i++) {
            citations[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                hIndex = n - i;
                break;
            }
        }

        System.out.println(hIndex);
        br.close();
    }
}