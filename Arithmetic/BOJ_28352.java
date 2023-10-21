// BOJ - 28352
// Problem Sheet - https://www.acmicpc.net/problem/28352

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        System.out.println(factorial(n) / (7 * 24 * 60 * 60));

        bf.close();
        System.exit(0);
    }

    private static long factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return (long)n * factorial(n-1);
    }
}