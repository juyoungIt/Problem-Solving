// BOJ - 20444
// Problem Sheet - https://www.acmicpc.net/problem/20444

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        boolean isValidCutting = false;
        long start = 0;
        long end = n / 2;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = (mid + 1) * (n - mid + 1);
            if (count < k) {
                start = mid + 1;
            } else if (count > k) {
                end = mid - 1;
            } else {
                isValidCutting = true;
                break;
            }
        }

        System.out.println((isValidCutting) ? "YES" : "NO");

        br.close();
        System.exit(0);
    }
}