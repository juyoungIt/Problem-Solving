// BOJ - 11726
// Problem Sheet - https://www.acmicpc.net/problem/11726

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 사각형의 가로 사이즈
        long[] cache = new long[1000+1]; // dp를 위해 사용할 cache

        cache[1] = 1;
        cache[2] = 2;
        for(int i=3 ; i<=n ; i++)
            cache[i] = (cache[i-2] + cache[i-1])%10007;

        System.out.println(cache[n]%10007);

        bf.close();
        System.exit(0);
    }
}