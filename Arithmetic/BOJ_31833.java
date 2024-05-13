// BOJ - 31833
// Problem Sheet - https://www.acmicpc.net/problem/31833

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String numberA = Arrays.stream(br.readLine().split(" ")).reduce((a, b) -> a + b).get();
        String numberB = Arrays.stream(br.readLine().split(" ")).reduce((a, b) -> a + b).get();

        System.out.println(Math.min(Long.parseLong(numberA), Long.parseLong(numberB)));

        br.close();
        System.exit(0);
    }
}