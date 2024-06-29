// BOJ - 24523
// Problem Sheet - https://www.acmicpc.net/problem/24523

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] indexes = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;
        indexes[n] = index;
        for (int i=n-1 ; i>0 ; i--) {
            if (a[i] != a[i+1]) {
                index = i+1;
            }
            indexes[i] = index;
        }

        for (int i=1 ; i<=n ; i++) {
            sb.append(indexes[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}