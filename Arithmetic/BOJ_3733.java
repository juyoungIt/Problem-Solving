// BOJ - 3733
// Problem Sheet - https://www.acmicpc.net/problem/3733

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input == null) break;
            int[] ns = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sb.append(ns[1] / (ns[0] + 1)).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}