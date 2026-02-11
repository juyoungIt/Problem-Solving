// BOJ - 24196
// Problem Sheet - https://www.acmicpc.net/problem/24196

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        sb.append(s.charAt(0));
        char last = s.charAt(0);
        int cur = 0;
        while (true) {
            cur += (last - 'A' + 1);
            if (cur >= s.length()) break;
            sb.append(s.charAt(cur));
            last = s.charAt(cur);
        }
        System.out.println(sb);
        br.close();
    }
}
