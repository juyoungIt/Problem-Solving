// BOJ - 23971
// Problem Sheet - https://www.acmicpc.net/problem/23971

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int row = w / (m + 1) + ((w % (m + 1) > 0) ? 1 : 0);
        int col = h / (n + 1) + ((h % (n + 1) > 0) ? 1 : 0);
        System.out.println(row * col);

        br.close();
        System.exit(0);
    }
}