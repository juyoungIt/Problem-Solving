// BOJ - 8710
// Problem Sheet - https://www.acmicpc.net/problem/8710

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println((w - k) % m == 0 ? (w - k) / m : (w - k) / m + 1);

        br.close();
        System.exit(0);
    }
}