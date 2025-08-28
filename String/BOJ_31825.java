// BOJ - 31825
// Problem Sheet - https://www.acmicpc.net/problem/31825

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int q = Integer.parseInt(row[1]);
        StringBuilder s = new StringBuilder(br.readLine());
        for (int i=0 ; i<q ; i++) {
            row = br.readLine().split(" ");
            int code = Integer.parseInt(row[0]);
            int l = Integer.parseInt(row[1]);
            int r = Integer.parseInt(row[2]);
            if (code == 1) {
                int gc = 1;
                char prev = s.charAt(l - 1);
                for (int j=l ; j<r ; j++) {
                    if (prev == s.charAt(j)) continue;
                    gc++;
                    prev = s.charAt(j);
                }
                sb.append(gc).append("\n");
            } else {
                for (int j=l-1 ; j<r ; j++) {
                    char c = s.charAt(j);
                    s.setCharAt(j, (char) ('A' + (c - 'A' + 1) % 26));
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
