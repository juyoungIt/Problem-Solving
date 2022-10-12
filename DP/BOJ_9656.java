// BOJ - 9656
// Problem Sheet - https://www.acmicpc.net/problem/9656

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 탁자 위 돌의 수
        int[] cache = new int[n+1]; // dp 접근을 위한 cache
        cache[1] = 1;
        if(n > 2) cache[3] = 1;

        int result  = findCount(cache, n);
        System.out.println((result%2==0) ? "SK" : "CY");

        bf.close();
        System.exit(0);
    }

    // 돌이 n개일 때 주고 받을 수 있는 순서의 수를 구함
    public static int findCount(int[] cache, int n) {
        if(cache[n] != 0)
            return cache[n];
        else {
            if(n%3 == 0) return cache[n] = findCount(cache, n-1) - 1;
            else return cache[n] = findCount(cache, n-1) + 1;
        }
    }
}