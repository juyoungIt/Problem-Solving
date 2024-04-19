// BOJ - 30018
// Problem Sheet - https://www.acmicpc.net/problem/30018

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] beforeCounts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] afterCounts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int misMatchedCount = 0;
        for (int i=0 ; i<n ; i++) {
            misMatchedCount += Math.abs(beforeCounts[i] - afterCounts[i]);
        }

        System.out.println(misMatchedCount / 2);

        br.close();
        System.exit(0);
    }
}