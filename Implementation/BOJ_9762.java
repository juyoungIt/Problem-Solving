// BOJ - 9762
// Problem Sheet - https://www.acmicpc.net/problem/9762

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] c = new int[n + 1];
            for (int i=n/2+1 ; i<=n ; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            for (int i=n/2 ; i>=1 ; i--) {
                int idx = i * 2;
                c[i] = Math.min(c[idx], c[idx + 1]);
                c[idx] -= c[i];
                c[idx + 1] -= c[i];
            }
            int sum = 0;
            for (int i=1 ; i<=n ; i++) {
                sum += c[i];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
