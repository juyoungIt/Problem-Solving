// BOJ - 2417
// Problem Sheet - https://www.acmicpc.net/problem/2417

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());

        System.out.println(binarySearch(n));

        bf.close();
        System.exit(0);
    }

    public static long binarySearch(long n) {
        if(n == 0) {
            return 0;
        }
        long left = 1;
        long right = 1L << 32;
        long sqrt = -1;
        while(left <= right) {
            long m = (left + right) / 2;
            if (m >= (n - 1) / m + 1) {
                right = m - 1;
                sqrt = m;
            }
            else {
                left = m + 1;
            }
        }
        return sqrt;
    }
}