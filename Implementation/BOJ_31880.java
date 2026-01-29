// BOJ - 31880
// Problem Sheet - https://www.acmicpc.net/problem/31880

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long answer = 0L;
        for (int i=0 ; i<n ; i++) {
            answer += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<m ; i++) {
            int bi = Integer.parseInt(st.nextToken());
            if (bi == 0) continue;
            answer *= bi;
        }
        System.out.println(answer);
        br.close();
    }
}
