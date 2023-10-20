// BOJ - 9550
// Problem Sheet - https://www.acmicpc.net/problem/9550

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int count = 0;
            for(int j=0 ; j<n ; j++) {
                count += Integer.parseInt(st.nextToken()) / k;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}