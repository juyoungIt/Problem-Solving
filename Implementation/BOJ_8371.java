// BOJ - 8371
// Problem Sheet - https://www.acmicpc.net/problem/8371

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}