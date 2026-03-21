// BOJ - 30958
// Problem Sheet - https://www.acmicpc.net/problem/30958

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[26];
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i=0 ; i<n ; i++) {
            char c = s.charAt(i);
            if (c - 'a' < 0 || c - 'a' > 25) continue;
            counts[c - 'a']++;
        }
        Arrays.sort(counts);
        System.out.println(counts[25]);
        br.close();
    }
}
