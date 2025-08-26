// BOJ - 32292
// Problem Sheet - https://www.acmicpc.net/problem/32292

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String before = s, after;
            while (true) {
                after = before.replaceFirst("ABB", "BA");
                if (before.equals(after)) break;
                before = after;
            }
            sb.append(after).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}