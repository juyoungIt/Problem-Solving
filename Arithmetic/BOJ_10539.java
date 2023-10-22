// BOJ - 10539
// Problem Sheet - https://www.acmicpc.net/problem/10539

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        long[] seq = new long[n+1];
        long[] result = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1 ; i<=n ; i++) {
            seq[i] = Long.parseLong(st.nextToken());
            result[i-1] = seq[i] * i + - seq[i-1] * (i-1);
        }

        for(int i=0 ; i<n ; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}