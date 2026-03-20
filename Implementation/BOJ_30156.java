// BOJ - 30156
// Problem Sheet - https://www.acmicpc.net/problem/30156

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] count = new int[2];
            String s = br.readLine();
            for (int i=0 ; i<s.length() ; i++) {
                count[s.charAt(i) - 'a']++;
            }
            sb.append(Math.min(count[0], count[1])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
