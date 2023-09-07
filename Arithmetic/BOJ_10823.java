// BOJ - 10823
// Problem Sheet - https://www.acmicpc.net/problem/10823

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = bf.readLine();
            if(input == null) break;
            sb.append(input);
        }

        long totalSum = Arrays.stream(sb.toString().split(","))
                .mapToLong(Long::parseLong)
                .sum();

        System.out.println(totalSum);

        bf.close();
        System.exit(0);
    }
}