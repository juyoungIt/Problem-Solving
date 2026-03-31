// BOJ - 18883
// Problem Sheet - https://www.acmicpc.net/problem/18883

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int value = 0;
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<m ; j++) {
                sb.append(++value);
                if (j == m - 1) continue;
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
