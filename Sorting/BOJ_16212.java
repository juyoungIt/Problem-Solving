// BOJ - 16212
// Problem Sheet - https://www.acmicpc.net/problem/16212

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(seq);

        for (int element : seq) {
            sb.append(element).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}