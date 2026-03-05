// BOJ - 32342
// Problem Sheet - https://www.acmicpc.net/problem/32342

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i=0 ; i<q ; i++) {
            String s = br.readLine();
            int count = 0;
            for (int j=0 ; j<s.length()-2 ; j++) {
                String sub = s.substring(j, j + 3);
                if (sub.equals("WOW")) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
