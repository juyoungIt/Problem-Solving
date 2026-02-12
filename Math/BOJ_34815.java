// BOJ - 34815
// Problem Sheet - https://www.acmicpc.net/problem/34815

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k % 2 != 0 && n == k) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        br.close();
    }
}