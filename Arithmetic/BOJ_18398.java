// BOJ - 18398
// Problem Sheet - https://www.acmicpc.net/problem/18398

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(a + b).append(" ").append(a * b).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}