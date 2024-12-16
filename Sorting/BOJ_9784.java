// BOJ - 9784
// Problem Sheet - https://www.acmicpc.net/problem/9784

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case %d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=T ; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int Q = Integer.parseInt(input[2]);
            int[] eggs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int count = 0;
            int totalWeight = 0;
            for (int j=0 ; j<n ; j++) {
                if (count < P && totalWeight + eggs[j] <= Q) {
                    count++;
                    totalWeight += eggs[j];
                } else {
                    break;
                }
            }
            sb.append(String.format(OUTPUT_FORMAT, i, count));
        }

        System.out.println(sb);
        br.close();
    }
}