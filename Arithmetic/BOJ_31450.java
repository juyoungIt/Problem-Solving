// BOJ - 31450
// Problem Sheet - https://www.acmicpc.net/problem/31450

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println((m % k == 0) ? "Yes" : "No");

        br.close();
        System.exit(0);
    }
}