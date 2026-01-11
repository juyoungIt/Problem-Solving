// BOJ - 5357
// Problem Sheet - https://www.acmicpc.net/problem/5357

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            char prev = ' ';
            for (int i=0 ; i<str.length() ; i++) {
                char cur = str.charAt(i);
                if (prev != cur) {
                    prev = cur;
                    sb.append(cur);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
