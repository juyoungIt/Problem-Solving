// BOJ - 26004
// Problem Sheet - https://www.acmicpc.net/problem/26004

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] counts = new int[5];
        for (int i=0 ; i<n ; i++) {
            int idx = getIndex(s.charAt(i));
            if (idx < 0) continue;
            counts[idx]++;
        }
        int minCount = 100_000;
        for (int count : counts) {
            minCount = Math.min(minCount, count);
        }
        System.out.println(minCount);
        br.close();
    }

    private static int getIndex(char c) {
        if (c == 'H') return 0;
        else if (c == 'I') return 1;
        else if (c == 'A') return 2;
        else if (c == 'R') return 3;
        else if (c == 'C') return 4;
        else return -1;
    }
}
