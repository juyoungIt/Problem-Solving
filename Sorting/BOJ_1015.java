// BOJ - 1015
// Problem Sheet - https://www.acmicpc.net/problem/1015

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[][] elements = new int[n][2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++) {
            elements[i][0] = Integer.parseInt(st.nextToken());
            elements[i][1] = i;
        }
        Arrays.sort(elements, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        int[] p = new int[n];
        for(int i=0 ; i<n ; i++) {
            p[elements[i][1]] = i;
        }
        for(int i=0 ; i<n ; i++) {
            sb.append(p[i]).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}