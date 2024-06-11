// BOJ - 2858
// Problem Sheet - https://www.acmicpc.net/problem/2858

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int w;
        for (int i=1 ; ; i++) {
            if (b % i == 0) {
                w = b / i;
                if (i * 2 + w * 2 + 4 == r) {
                    System.out.printf("%d %d\n", w + 2, i + 2);
                    break;
                }
            }
        }

        br.close();
        System.exit(0);
    }
}