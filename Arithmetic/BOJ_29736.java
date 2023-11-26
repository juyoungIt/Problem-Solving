// BOJ - 29736
// Problem Sheet - https://www.acmicpc.net/problem/29736

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int left = Math.max(a, k - x);
        int right = Math.min(b, k + x);

        if(left <= right) {
            System.out.println(right - left + 1);
        } else {
            System.out.println("IMPOSSIBLE");
        }

        br.close();
        System.exit(0);
    }
}