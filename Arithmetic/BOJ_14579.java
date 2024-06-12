// BOJ - 14579
// Problem Sheet - https://www.acmicpc.net/problem/14579

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tmp = ((a + 1) * a / 2) % 14_579;
        int result = tmp;
        for (int i=a+1 ; i<=b ; i++) {
            tmp += i;
            result *= tmp;
            result %= 14_579;
        }

        System.out.println(result);

        br.close();
        System.exit(0);
    }
}