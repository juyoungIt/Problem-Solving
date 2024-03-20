// BOJ - 18247
// Problem Sheet - https://www.acmicpc.net/problem/18247

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n < 12 || m < 4) {
                sb.append(-1).append("\n");
                continue;
            }
            sb.append(11 * m + 4).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}