// BOJ - 2783
// Problem Sheet - https://www.acmicpc.net/problem/2783

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        double result = (double)x / y * 1_000;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            result = Math.min(result, (double)xi / yi * 1_000);
        }

        System.out.printf("%.2f\n", result);

        br.close();
    }
}