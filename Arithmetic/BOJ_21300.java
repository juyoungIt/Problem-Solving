// BOJ - 21300
// Problem Sheet - https://www.acmicpc.net/problem/21300

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalBottles = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(totalBottles * 5);

        br.close();
        System.exit(0);
    }
}