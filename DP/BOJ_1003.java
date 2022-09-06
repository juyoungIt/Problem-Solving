// BOJ - 1003
// Problem Sheet - https://www.acmicpc.net/problem/1003

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] cache = new int[40+1]; // 각각의 중간값을 저장

        int tcSize = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
        for(int i=0 ; i<tcSize ; i++) {
            int tc = Integer.parseInt(bf.readLine()); // 입력받은 수
            fibo(tc, cache);
            if(tc == 0)
                System.out.println("1 0");
            else
                System.out.println(cache[tc-1] + " " + cache[tc]);
        }

        bf.close();
        System.exit(0);
    }

    public static int fibo(int n, int[] cache) {
        if(n == 0) {
            cache[0] = 0;
            return cache[0];
        }
        else if(n == 1) {
            cache[1] = 1;
            return cache[1];
        }
        else {
            if(cache[n] != 0)
                return cache[n];
            else
                return cache[n] = fibo(n-1, cache) + fibo(n-2, cache);
        }
    }
}