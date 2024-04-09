// BOJ - 28061
// Problem Sheet - https://www.acmicpc.net/problem/28061

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxLemonCnt = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            int curLemonCnt = Integer.parseInt(st.nextToken()) - (n - i);
            maxLemonCnt = Math.max(maxLemonCnt, curLemonCnt);
        }

        System.out.println(maxLemonCnt);

        br.close();
        System.exit(0);
    }
}