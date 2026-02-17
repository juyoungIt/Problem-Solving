// BOJ - 17010
// Problem Sheet - https://www.acmicpc.net/problem/17010

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            sb.append(String.valueOf(c).repeat(Math.max(0, n))).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}