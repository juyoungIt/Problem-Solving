// BOJ - 26122
// Problem Sheet - https://www.acmicpc.net/problem/26122

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();

        if (k <= 1) {
            System.out.println(0);
            return;
        }

        int maxLen = 0;
        int prev = 0;
        int cur = 1;

        for (int i=1 ; i<k ; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                if (prev > 0) maxLen = Math.max(maxLen, 2 * Math.min(prev, cur));
                prev = cur;
                cur = 1;
            }
        }

        if (prev > 0) {
            maxLen = Math.max(maxLen, 2 * Math.min(prev, cur));
        }
        System.out.println(maxLen);
        br.close();
    }
}