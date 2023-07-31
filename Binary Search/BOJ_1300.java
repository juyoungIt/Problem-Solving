// BOJ - 1300
// Problem Sheet - https://www.acmicpc.net/problem/1300

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        long left = 1;
        long right = K;
        long optimalIndex = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(int i=1 ; i<=N ; i++) {
                count += Math.min(mid / i, N);
            }
            if(K <= count) {
                optimalIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(optimalIndex);

        bf.close();
        System.exit(0);
    }
}