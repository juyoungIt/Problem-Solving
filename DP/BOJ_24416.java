// BOJ - 24416
// Problem Sheet - https://www.acmicpc.net/problem/24416

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] cache = new int[n+1]; // dp를 위해 사용하는 cache
        int[] callCount = new int[2]; // 두 방식의 호출횟수를 저장

        fibo_rec(n, callCount);
        fibo_dp(cache, n, callCount);

        System.out.println(callCount[0] + " " + callCount[1]);

        bf.close();
        System.exit(0);
    }

    public static int fibo_rec(int n, int[] callCount) {
        if(n == 1 || n == 2) {
            callCount[0]++;
            return 1;
        }
        else
            return fibo_rec(n-2, callCount) + fibo_rec(n-1,callCount);
    }

    public static int fibo_dp(int[] cache, int n, int[] callCount) {
        cache[1] = 1;
        cache[2] = 1;
        for(int i=3 ; i<=n ; i++) {
            callCount[1]++;
            cache[i] = cache[i-2] + cache[i-1];
        }
        return cache[n];
    }
}