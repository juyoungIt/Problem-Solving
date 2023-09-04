// BOJ - 11024
// Problem Sheet - https://www.acmicpc.net/problem/11024

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            int sum = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}