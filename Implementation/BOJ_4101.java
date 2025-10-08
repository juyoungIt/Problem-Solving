// BOJ - 4101
// Problem Sheet - https://www.acmicpc.net/problem/4101

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            sb.append(a > b ? "Yes" : "No").append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
