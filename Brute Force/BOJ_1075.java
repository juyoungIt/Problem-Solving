// BOJ - 1075
// Problem Sheet - https://www.acmicpc.net/problem/1075

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        n -= (n % 100);
        int part = 0;
        for (int i=0 ; i<100 ; i++) {
            int tmp = n + i;
            if (tmp % f == 0) {
                part = tmp % 100;
                break;
            }
        }
        System.out.printf("%02d\n", part);
        br.close();
    }
}
