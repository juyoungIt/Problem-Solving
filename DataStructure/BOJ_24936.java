// BOJ - 24936
// Problem Sheet - https://www.acmicpc.net/problem/24936

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] distances = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = Arrays.stream(distances).sum();

        Set<Integer> possibleSum = new HashSet<>();
        Arrays.stream(distances).forEach(d -> possibleSum.add(sum - d));
        sb.append(possibleSum.size()).append("\n");
        Arrays.stream(possibleSum.stream().sorted().mapToInt(Integer::intValue).toArray())
                .forEach(s -> sb.append(s).append(" "));

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}