// BOJ - 9076
// Problem Sheet - https://www.acmicpc.net/problem/9076

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int[] scores = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            if (scores[3] - scores[1] >= 4) {
                sb.append("KIN").append("\n");
            } else {
                int sum = scores[1] + scores[2] + scores[3];
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}