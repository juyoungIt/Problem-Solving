// BOJ - 34704
// Problem Sheet - https://www.acmicpc.net/problem/34704

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            counts[Integer.parseInt(st.nextToken())]++;
        }
        br.close();
        int boxCount = counts[4];
        boxCount += counts[3];
        int pair = Math.min(counts[3], counts[1]);
        counts[1] -= pair;
        boxCount += counts[2] / 2;
        counts[2] = counts[2] % 2;
        if (counts[2] == 1) {
            boxCount++;
            int pair_2_1 = Math.min(counts[1], 2);
            counts[1] -= pair_2_1;
        }
        boxCount += (counts[1] + 3) / 4;
        System.out.println(boxCount);
    }
}