// BOJ - 28353
// Problem Sheet - https://www.acmicpc.net/problem/28353

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cats = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        boolean[] isAssigned = new boolean[n];

        int happyCount = 0;
        for (int i=0 ; i<n-1 ; i++) {
            for (int j=n-1 ; j>i ; j--) {
                if (!isAssigned[i] && !isAssigned[j] && cats[i] + cats[j] <= k) {
                    happyCount++;
                    isAssigned[i] = true;
                    isAssigned[j] = true;
                }
            }
        }
        System.out.println(happyCount);

        br.close();
    }
}