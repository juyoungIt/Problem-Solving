// BOJ - 2975
// Problem Sheet - https://www.acmicpc.net/problem/2975

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
            char b = st.nextToken().charAt(0);
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 'W' && c == 0) break;

            if (b == 'W') a -= c;
            else a += c;

            if (a < -200) sb.append("Not allowed").append("\n");
            else sb.append(a).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}