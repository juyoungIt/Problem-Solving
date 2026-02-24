// BOJ - 33288
// Problem Sheet - https://www.acmicpc.net/problem/33288

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i=0 ; i<n ; i++) {
            char c = s.charAt(i);
            if (c == 'I') sb.append("i");
            if (c == 'l') sb.append("L");
        }
        System.out.println(sb);
        br.close();
    }
}
