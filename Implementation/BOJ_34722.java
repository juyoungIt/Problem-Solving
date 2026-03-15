// BOJ - 34722
// Problem Sheet - https://www.acmicpc.net/problem/34722

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int count = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (isValid(s, c, a, r)) {
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }

    private static boolean isValid(int s, int c, int a ,int r) {
        return s >= 1_000 || c >= 1_600 || a >= 1_500 || (1 <= r && r <= 30);
    }
}
