// BOJ - 16917
// Problem Sheet - https://www.acmicpc.net/problem/16917

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if(a + b < 2 * c) {
            System.out.println(a * x + b * y);
        } else {
            System.out.println(2 * c * Math.min(x, y)
                    + Math.min(a, 2 * c) * Math.max(0, x - y)
                    + Math.min(b, 2 * c) * Math.max(0, y - x));
        }

        br.close();
        System.exit(0);
    }
}