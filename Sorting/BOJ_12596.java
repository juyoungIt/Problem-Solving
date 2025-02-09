// BOJ - 12596
// Problem Sheet - https://www.acmicpc.net/problem/12596

import java.util.*;
import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case #%d: %d";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=N ; i++) {
            int G = Integer.parseInt(br.readLine());
            int[] C = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int uniqueCode = -1;
            for (int j=0 ; j<G-1 ; j++) {
                if (C[j] != C[j + 1]) {
                    uniqueCode = C[j];
                    break;
                }
                j++;
            }
            sb.append(String.format(OUTPUT_FORMAT, i, uniqueCode < 0 ? C[G-1] : uniqueCode)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}