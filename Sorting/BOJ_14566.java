// BOJ - 14566
// Problem Sheet - https://www.acmicpc.net/problem/14566

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int minDist = arr[n-1] - arr[0];
        int sameDistPairCount = 0;
        for (int i=1 ; i<n ; i++) {
            int dist = arr[i] - arr[i - 1];
            if (dist == minDist) {
                sameDistPairCount++;
            } else if (dist < minDist) {
                minDist = dist;
                sameDistPairCount = 1;
            }
        }

        System.out.printf("%d %d\n", minDist, sameDistPairCount);
        br.close();
    }
}