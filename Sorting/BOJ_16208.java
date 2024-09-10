// BOJ - 16208
// Problem Sheet - https://www.acmicpc.net/problem/16208

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rods = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int totalLength = Arrays.stream(rods).sum();
        Arrays.sort(rods);

        long minPrice = 0;
        for (int i=0 ; i<n-1 ; i++) {
            totalLength -= rods[i];
            minPrice += (long) rods[i] * totalLength;
        }
        System.out.println(minPrice);

        br.close();
        System.exit(0);
    }
}