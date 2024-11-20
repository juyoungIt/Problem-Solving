// BOJ - 12723
// Problem Sheet - https://www.acmicpc.net/problem/12723

import java.util.*;
import java.io.*;

public class Main {

    private static final int MAX_VALUE = 1_001;
    private static final String MESSAGE_FORMAT = "Case #%d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] vertorA = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] vertorB = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int minProduct = 0;
            for (int j=0 ; j<n ; j++) {
                minProduct += vertorA[j] * vertorB[n - 1 - j];
            }
            sb.append(String.format(MESSAGE_FORMAT, i, minProduct));
        }

        System.out.println(sb);
        br.close();
    }
}