// BOJ - 16504
// Problem Sheet - https://www.acmicpc.net/problem/16504

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long totalSum = 0;
        for (int i=0 ; i<n ; i++) {
            totalSum += Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .sum();
        }

        System.out.println(totalSum);

        br.close();
        System.exit(0);
    }
}