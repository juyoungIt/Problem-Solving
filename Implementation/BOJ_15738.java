// BOJ - 15738
// Problem Sheet - https://www.acmicpc.net/problem/15738

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.readLine();
        for (int i=0 ; i<m ; i++) {
            int q = Integer.parseInt(br.readLine());
            k = reverse(k, q, n);
        }
        br.close();
        System.out.println(k);
    }

    private static int reverse(int curIndex, int query, int n) {
        if (query > 0 && curIndex > query || query < 0 && curIndex <= n + query) return curIndex;
        return query > 0 ? query - curIndex + 1 : (n + query + 1) + n - curIndex;
    }
}
