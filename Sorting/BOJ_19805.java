// BOJ - 19805
// Problem Sheet - https://www.acmicpc.net/problem/19805

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] flowers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(f -> Math.max(f % 2 == 1 ? f : f - 1, 0))
                .sorted()
                .toArray();

        int totalSum = Arrays.stream(flowers).sum();
        System.out.println(n % 2 == 0 ? totalSum - flowers[0] : totalSum);
        br.close();
    }
}