// BOJ - 25494
// Problem Sheet - https://www.acmicpc.net/problem/25494

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<T ; i++) {
            int[] numbers = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sb.append(Math.min(Math.min(numbers[0], numbers[1]), numbers[2]))
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}