// BOJ - 23303
// Problem Sheet - https://www.acmicpc.net/problem/23303

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=t ; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] result = new int[n];
            int maxLen = 1;
            for (int j=0 ; j<n ; j++) {
                if (j == 0) {
                    result[j] = maxLen;
                } else {
                    if (s.charAt(j - 1) < s.charAt(j)) {
                        result[j] = ++maxLen;
                    } else {
                        maxLen = 1;
                        result[j] = maxLen;
                    }
                }
            }
            sb.append("Case #").append(i).append(": ");
            for (int count : result) sb.append(count).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}