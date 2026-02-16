// BOJ - 31656
// Problem Sheet - https://www.acmicpc.net/problem/31656

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        sb.append(s.charAt(0));
        char prev = s.charAt(0);
        for (int i=1 ; i<s.length() ; i++) {
            if (s.charAt(i) == prev) continue;
            sb.append(s.charAt(i));
            prev = s.charAt(i);
        }
        System.out.println(sb);
        br.close();
    }
}