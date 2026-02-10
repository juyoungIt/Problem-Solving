// BOJ - 9699
// Problem Sheet - https://www.acmicpc.net/problem/9699

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=1 ; i<=t ; i++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int j=0 ; j<5 ; j++) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }
            sb.append("Case #").append(i).append(": ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
