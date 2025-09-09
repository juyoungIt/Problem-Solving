// BOJ - 21030
// Problem Sheet - https://www.acmicpc.net/problem/21030

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String t = br.readLine();
        int[] count = new int[26];
        for (int i=0 ; i<n ; i++) {
            count[s.charAt(i) - 'a']++;
            if (s.charAt(i) != t.charAt(i)) {
                count[t.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        for (int i=0 ; i<26 ; i++) {
            max = Math.max(max, count[i]);
        }
        System.out.println(max);
        br.close();
    }
}