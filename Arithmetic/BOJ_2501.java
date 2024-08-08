// BOJ - 2501
// Problem Sheet - https://www.acmicpc.net/problem/2501

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int divisorCount = 0;
        int answer = 0;
        for (int i=1 ; i<=n ; i++) {
            if (n % i == 0) {
                divisorCount++;
                if (divisorCount == k) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}