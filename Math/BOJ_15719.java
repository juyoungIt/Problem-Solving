// BOJ - 15719
// Problem Sheet - https://www.acmicpc.net/problem/15719

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.println(sum - (((long) n - 1) * n / 2));
        br.close();
    }
}
