// BOJ - 15238
// Problem Sheet - https://www.acmicpc.net/problem/15238

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[26];
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i=0 ; i<n ; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int maxCount = 0, maxIdx = 0;
        for (int i=0 ; i<26 ; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIdx = i;
            }
        }
        System.out.printf("%c %d\n", (char) ('a' + maxIdx), maxCount);
        br.close();
    }
}
