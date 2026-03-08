// BOJ - 11257
// Problem Sheet - https://www.acmicpc.net/problem/11257

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int sum = s + m + t;
            sb.append(id).append(" ").append(sum).append(" ");
            if (s >= 35 * 0.3 && m >= 25 * 0.3 && t >= 40 * 0.3 && sum >= 55) {
                sb.append("PASS");
            } else {
                sb.append("FAIL");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
