// BOJ - 4562
// Problem Sheet - https://www.acmicpc.net/problem/4562

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(x >= y ? "MMM" : "NO").append(" BRAINS\n");
        }
        System.out.println(sb);
        br.close();
    }
}
