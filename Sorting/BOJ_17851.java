// BOJ - 17851
// Problem Sheet - https://www.acmicpc.net/problem/17851

import java.util.*;
import java.io.*;

public class Main {

    private static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        arrB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();
    }

    private static int solve() {
        int count = 0;
        for (int i=0 ; i<arrA.length ; i++) {
            if (arrA[i] > arrB[i]) {
                count++;
            }
        }
        return count;
    }
}