// BOJ - 13301
// Problem Sheet - https://www.acmicpc.net/problem/13301

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // 타일의 갯수
        long[][] cache = new long[n+1][2];

        cache[1][0] = 1;
        cache[1][1] = 1;

        long[] sides = getSides(cache, n);
        System.out.println(sides[0]*2 + sides[1]*2);


        bf.close();
        System.exit(0);
    }

    public static long[] getSides(long[][] cache, int n) {
        if(cache[n][0] == 0 && cache[n][1] == 0) {
            long[] tmp = getSides(cache, n-1);
            cache[n][0] = tmp[1];
            cache[n][1] = tmp[0] + tmp[1];
        }
        return cache[n];
    }
}