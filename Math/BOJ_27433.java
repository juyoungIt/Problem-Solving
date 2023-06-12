// BOJ - 27433
// Problem Sheet - https://www.acmicpc.net/problem/27433

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(bf.readLine());
        System.out.println(getFactorial(n));

        bf.close();
        System.exit(0);
    }

    private static long getFactorial(long n) {
        if(n == 0) {
            return 1;
        }
        return n * getFactorial(n-1);
    }
}