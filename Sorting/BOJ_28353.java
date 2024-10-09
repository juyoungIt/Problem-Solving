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

        int happyCount = 0;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int totalWeight = cats[start] + cats[end];
            if (totalWeight <= k) {
                happyCount++;
                start++;
                end--;
            } else {
                end--;
            }
        }

        System.out.println(happyCount);

        br.close();
    }
}