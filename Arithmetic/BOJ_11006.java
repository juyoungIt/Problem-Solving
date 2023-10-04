// BOJ - 11006
// Problem Sheet - https://www.acmicpc.net/problem/11006

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int u = 2 * m - n;
            int t = m - u;
            sb.append(u).append(" ").append(t).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}