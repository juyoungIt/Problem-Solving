// BOJ - 1072
// Problem Sheet - https://www.acmicpc.net/problem/1072

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        if (y * 100 / x >= 99) {
            System.out.println(-1);
            System.exit(0);
        }

        long basePercentage = y * 100 / x;
        long left = 1;
        long right = x;
        while(left < right) {
            long mid = (left + right) / 2;
            long curPercentage = (y + mid) * 100 / (x + mid);
            if (curPercentage > basePercentage) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);

        br.close();
        System.exit(0);
    }
}