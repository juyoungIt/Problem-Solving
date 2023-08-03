// BOJ - 9325
// Problem Sheet - https://www.acmicpc.net/problem/9325

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            int sum = 0;
            sum += Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            for(int j=0 ; j<n ; j++) {
                st = new StringTokenizer(bf.readLine());
                int q = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                sum += q * p;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}