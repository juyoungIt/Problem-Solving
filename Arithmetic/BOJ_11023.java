// BOJ - 11023
// Problem Sheet - https://www.acmicpc.net/problem/11023

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalSum = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(totalSum);

        bf.close();
        System.exit(0);
    }
}